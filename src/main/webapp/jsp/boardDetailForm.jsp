<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="vada.dto.CategoryDTO"%>
<%@ page import="java.util.Map"%>
<%@ page import="vada.dto.ProductpriceDTO"%>
<%@ page import="vada.dto.BoardDTO"%>
<%@ page import="vada.service.BoardViewService"%>
<%@ page import="vada.dao.impl.BoardViewDAOImpl"%>
<%@ page import="vada.dao.BoardDAO"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<jsp:include page="top.jsp" />

<style>
.container>img {
	width: 10%;
}

.swiper-container {
	height: 200px;
	width: 630px;
	position: relative;
	overflow: hidden;
	list-style: none;
	z-index: 1;
	padding-bottom: 30px;
}

.swiper-slide {
	text-align: center;
	/* 	display: flex; /* 내용을 중앙정렬 하기위해 flex 사용 */ */
	align-items: center; /* 위아래 기준 중앙정렬 */
	justify-content: center; /* 좌우 기준 중앙정렬 */
	display: inline;
}

.swiper-slide img {
	max-width: 100%;
	height: auto;
	display: block;
}
</style>

<%
String productnum = (String) request.getParameter("productnum");
System.out.println("productnum ==============> " + productnum);

ProductpriceDTO productpriceDTO = new ProductpriceDTO();
BoardDTO boardDTO = new BoardDTO();
CategoryDTO categoryDTO = new CategoryDTO();

BoardViewService boardViewService = new BoardViewDAOImpl();

Map<String, Object> map = boardViewService.viewBoard(Integer.parseInt(productnum));
System.out.println("map ==============> " + map);

boardDTO = (BoardDTO) map.get("boardDTO");

productpriceDTO = (ProductpriceDTO) map.get("ProductpriceDTO");
categoryDTO = (CategoryDTO) map.get("categoryDTO");

List list1 = (List) map.get("imglist1");
List list2 = (List) map.get("imglist2");
List list3 = (List) map.get("imglist3");

pageContext.setAttribute("boardDTO", boardDTO);
String reserveText = "판매중";
if (!boardDTO.getBuyerid().equals("default")) {
	reserveText = "판매완료";
} else {
	if (boardDTO.getReservation().equals("yes")) {
		reserveText = "판매예약";
	} else {
		reserveText = "판매중";
	}
}
pageContext.setAttribute("reserveText", reserveText);

pageContext.setAttribute("productpriceDTO", productpriceDTO);

pageContext.setAttribute("categoryDTO", categoryDTO);

pageContext.setAttribute("imglist1", list1); // imgsname만 있는 리스트
pageContext.setAttribute("imglist2", list2); // imgcname만 있는 리스트
pageContext.setAttribute("imglist3", list3); // imgsize만 있는 리스트

pageContext.setAttribute("sellerid", boardDTO.getSellerid());
pageContext.setAttribute("buyerid", boardDTO.getBuyerid());

//구매완료 판매완료 제목에 추가 
System.out.println("boardDTO ===========================> " + boardDTO);

pageContext.setAttribute("productpriceDTO", productpriceDTO);
System.out.println("productpriceDTO ===========================> " + productpriceDTO);

pageContext.setAttribute("categoryDTO", categoryDTO);
System.out.println("categoryDTO ===========================> " + categoryDTO);

pageContext.setAttribute("reserveText", reserveText);
%>
<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<main>

	<div style="margin-left: 25%">

		<form action="/Vada/jsp/boardUpdateForm.jsp" method="post">
			<input type="hidden" name="productnum" value="${boardDTO.productnum}" />


			<!-- 	이미지 슬라이드 -->
			<div class="swiper-container">
				<div class="swiper-wrapper">
					<c:forEach var="item1" items="${imglist1}" varStatus="status">
						<div class="swiper-slide">
							<img style="width:100%; height:100%;" src="../${item1}" name="img">
						</div>
					</c:forEach>

					<c:forEach var="item2" items="${imglist2}" varStatus="status">
						<input type="hidden" name="imgcname${status.index}"
							value="${item2}" />
					</c:forEach>

					<c:forEach var="item3" items="${imglist3}" varStatus="status">
						<input type="hidden" name="imgsize${status.index}"
							value="${item3}" />
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
						href="javascript:confirmCommand('/Vada/jsp/notifyWriteForm.jsp?productnum=${boardDTO.productnum}&title=${boardDTO.title}','게시글 신고');">게시글
						신고</a><br /> <br /> <br />
					<%
					// TODO EL로 바꿔야함
					%>
					<c:if
						test="${sessionScope.userid ne boardDTO.sellerid and boardDTO.reserveid eq 'default'}">
						<a class="btn btn-secondary" style="float: right"
							href="javascript:confirmCommand('/Vada/jsp/reserveProc.jsp?productnum=${boardDTO.productnum}&command=reserve','구매예약');">구매예약</a>

					</c:if>
					<c:if test="${sessionScope.userid eq boardDTO.reserveid}">
						<a class="btn btn-secondary" style="float: right"
							href="javascript:confirmCommand('/Vada/jsp/reserveProc.jsp?productnum=${boardDTO.productnum}&command=cancel','예약취소');">예약취소</a>
						<br />
					</c:if>
					<br /> <br />
					<h3>
						제목 : <input type="text" name="title" value="${boardDTO.title}" />
					</h3>

					<h3>내용</h3>
					<textarea style="width: 100%" name="content">${boardDTO.content}</textarea>
					<br />
					<h3>카테고리 : ${categoryDTO.categoryname}</h3>
					<h3>
						가격 : <input type="text" name="productprice"
							value="${productpriceDTO.productprice}" />
					</h3>
					<br />
					
					<h3>(${reserveText})</h3>
					
					<c:if test="${!empty boardDTO.review}}">
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

						<c:if test="${sessionScope.userid eq boardDTO.sellerid}">
							<input type="button" class="btn btn-secondary" onclick ="this.form.submit()" value="글 수정">

							<script src="/Vada/js/common.js"></script>
							<a class="btn btn-secondary"
								href="javascript:confirmCommand('/Vada/jsp/boardDeleteProc.jsp?productnum=${boardDTO.productnum}','게시글 삭제');">글
								삭제</a>
							<c:if test="${empty boardDTO.soldoutdate and boardDTO.reservation eq 'yes'}">
								<a class="btn btn-secondary" style="color: yellow"
									href="javascript:confirmCommand('/Vada/jsp/soldOutProc.jsp?productnum=${boardDTO.productnum}&reserveid=${boardDTO.reserveid}','구매');">판매완료</a>
							</c:if>
						</c:if>
						<c:if test="${sessionScope.userid ne boardDTO.sellerid}">

							<a href="#" class="btn btn-info" style="float: right color: red">채팅하기&raquo;</a>
							<a class="btn btn-secondary"
								style="float: right; margin-right: 5px;"
								href="javascript:confirmCommand('/Vada/jsp/addLikeProc.jsp?productnum=${boardDTO.productnum}','찜');">찜하기</a>
						</c:if>
					</p>
				</div>
			</div>
		</form>
		<a href="/Vada/jsp/mainForm.jsp" class="btn btn-secondary">메인 화면으로
			돌아가기</a>

	</div>

</main>

<jsp:include page="bottom.jsp" />