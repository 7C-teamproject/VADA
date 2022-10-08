<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<jsp:include page="top.jsp" />

<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<main>

	<div style="margin-left: 25%">

		<form action="/Vada/boardupdateform.do" method="post">
			<input type="hidden" name="productnum" value="${boardDTO.productnum}" />

			<!-- 	이미지 슬라이드 -->
			<div class="swiper-container" onclick="swiper()">
				<div class="swiper-wrapper">
					<c:forEach var="item" items="${imgsnameList}" varStatus="status">
						<div class="swiper-slide">
							<img style="width: 100%; height: 100%;" src="/Vada/img${item}" name="img">
							<input type="hidden" name="imgcname${status.index}"
								value="${imgcnameList[status.index]}" /> <input type="hidden"
								name="imgsize${status.index}" value="${imgsizeList[status.index]}" />
						</div>
					</c:forEach>

				</div>
				<div class="swiper-pagination"></div>
				<div class="swiper-button-next"></div>
				<div class="swiper-button-prev"></div>
			</div>

			<script>
				new Swiper('.swiper-container', {
					loop : true,
					spaceBetween : 30,
					pagination : {
						el : ".swiper-pagination",
						clickable : true,
						type : 'fraction'
					},
					navigation : {
						nextEl : ".swiper-button-next",
						prevEl : ".swiper-button-prev",
					},
				});
			</script>

			<script src="/Vada/js/common.js"></script>
			<div class="row">
				<div class="col-md-6">
					<a class="btn btn-secondary" style="float: right"
						href="javascript:confirmCommand('/Vada/notifywriteform.do?productnum=${boardDTO.productnum}&title=${boardDTO.title}','게시글 신고');">게시글
						신고</a><br /> <br /> <br />

					<!-- 다른 사람이 올린 게시글이 예약중이 아니면 구매 예약 버튼 표시 -->
					<c:if
						test="${sessionScope.userid ne boardDTO.sellerid and boardDTO.reserveid eq 'default' and boardDTO.reservation eq 'no'}">
						<a class="btn btn-secondary" style="float: right"
							href="javascript:confirmCommand('/Vada/reserveproc.do?productnum=${boardDTO.productnum}&command=reserve','구매예약');">구매예약</a>
					</c:if>
					
					<!-- 내가 예약한 게시글이면 예약 취소 버튼 표시 -->
					<c:if test="${sessionScope.userid eq boardDTO.reserveid and boardDTO.reservation eq 'yes'}">
						<a class="btn btn-secondary" style="float: right"
							href="javascript:confirmCommand('/Vada/reserveproc.do?productnum=${boardDTO.productnum}&command=cancel','예약취소');">예약취소</a>
						<br />
					</c:if>
					<br /> <br />
					
					<h3>
						제목 : ${boardDTO.title}<input type="hidden" name="title" value="${boardDTO.title}" />
					</h3>

					<h3>내용</h3>
					<textarea readonly style="width: 100%" name="content">${boardDTO.content}</textarea>
					<br />
					<h3>카테고리 : ${categoryDTO.categoryname}</h3><input type="hidden" name="bcategorynum" value="${categoryDTO.categoryname}" />
					<h3>가격 :  <fmt:formatNumber value="${productpriceDTO.productprice}" pattern="#,###" />원</h3>
					<input type="hidden" name="productprice" value="${productpriceDTO.productprice}" />
					<br />

					<!-- 판매중/예약중/판매완료 상태 텍스트 출력 -->
					<h3>(${reserveText})</h3>

					<!-- 후기글이 있으면 후기글 화면에 출력 -->
					<c:if test="${!empty boardDTO.review}">
						<h3>리뷰 : ${boardDTO.review}</h3>
						<h3>
							별점 :

							<c:forEach var="i" begin="1" end="${boardDTO.reviewscore}">   
						 		<span style="color: FFF064; font-size: xx-large;">★</span>
							</c:forEach>

						</h3>
					</c:if>
					<br /> <br />
					<p>
					<% // TODO 예약/판매중/판매완료 상태 처리해야함 %>
						<!-- 로그인한 사용자가 작성한 게시글이면 글 수정/삭제 가능 -->
						<c:if test="${sessionScope.userid eq boardDTO.sellerid or sessionScope.adminyn eq 'yes'}">
							<input type="button" class="btn btn-secondary"
								onclick="this.form.submit()" value="글 수정">

							<script src="/Vada/js/common.js"></script>
							<a class="btn btn-secondary"
								href="javascript:confirmCommand('/Vada/boarddeleteproc.do?productnum=${boardDTO.productnum}','게시글 삭제');">글
								삭제</a>
								
							<!-- 해당 게시글이 판매 완료 게시글 이면 "판매 완료" 출력 -->
							<c:if test="${empty boardDTO.soldoutdate}">
								<a class="btn btn-secondary" style="color: yellow"
									href="javascript:confirmCommand('/Vada/soldoutproc.do?productnum=${boardDTO.productnum}&reserveid=${boardDTO.reserveid}','구매');">판매완료</a>
							</c:if>
							
							<!-- 해당 게시글이 예약중인 게시글 이면 "예약중" 출력 -->
							<c:if test="${boardDTO.reservation eq 'yes'}">
								<a class="btn btn-secondary" style="color: yellow"
									href="javascript:confirmCommand('/Vada/soldoutproc.do?productnum=${boardDTO.productnum}&reserveid=${boardDTO.reserveid}','구매');">예약중</a>
							</c:if>
						</c:if>
						
						<!-- 해당 게시글이 판매중이고, 현재 로그인 한 사용자가 아닌 다른 사람이 올린 게시글이면 채팅/쪽지/찜하기 가능 -->
						<c:if test="${!empty boardDTO.soldoutdate}">
							<c:if test="${sessionScope.userid ne boardDTO.sellerid}">
								<a href=" /Vada/jsp/chatList.jsp?productnum=${boardDTO.productnum}&userid=${sessionScope.userid}"class="btn btn-info" style="float: right color: red">채팅하기&raquo;</a>
								<a href="/Vada/jsp/NoteMessageWriteForm.jsp?productnum=${boardDTO.productnum}&sellerid=${boardDTO.sellerid}" class="btn btn-info" style="float: right color: red">쪽지 보내기&raquo;</a>
								<a class="btn btn-secondary"
									style="float: right; margin-right: 5px;"
									href="javascript:confirmCommand('/Vada/addlikeproc.do?productnum=${boardDTO.productnum}','찜');">찜하기</a>
							</c:if>
						</c:if>
					</p>
				</div>
			</div>
		</form>
		
		<div>		
			<a href="/Vada/jsp/mainformindex.jsp" class="btn btn-secondary">메인 화면으로 돌아가기</a>
		</div>

	</div>

</main>

<jsp:include page="bottom.jsp" />