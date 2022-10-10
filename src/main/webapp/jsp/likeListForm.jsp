<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="top.jsp" />

<link href="/Vada/css/list.css" rel="stylesheet" />

<main>

	<div class="list con">
		<div class="container">
			<table class="table table-stripped"
				style="text-align: center; boarder: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="2"
							style="background-color: #eeeeee; text-align: center;">찜 목록</th>
					</tr>
				</thead>
			</table>
		</div>
		<ul class="row" id="test">
			
			
			<c:set var="listSize" value="${list.size()}" />
			
			<!-- User의 찜목록이 존재한다면 -->
			<c:if test="${fn:length(list) != 0}">
				<c:forEach var="item" items="${list}" varStatus="stat">

					<li id="listid" class="cell">
						<div class="img-box">
						
							<!-- 첫번째 이미지파일을 출력 -->
							<img class=imgfile src="${item.imgsname}" alt="">
						</div>
						<h4>
							가격 :
							<fmt:formatNumber value="${item.productprice}" pattern="#,###" />
							원
						</h4>
						<div class="product-price">
							
							<!-- 해당 찜게시글에 해당하는 폼으로 이동 -->
							<a href="/Vada/boarddetailform.do?productnum=${item.productnum}">${item.title}</a>
						</div> <c:set var="sysYear">
							<fmt:formatDate value="${item.wdate}"
								pattern="yyyy-MM-dd hh:mm:ss" />
						</c:set>
						<div class="product-name">
							<c:out value="${sysYear}" />

							<script src="/Vada/js/common.js"></script>
							<a class="btn btn-secondary" style="float: right;"
								href="javascript:confirmCommand('/Vada/likelistdeleteproc.do?productnum=${item.productnum}','찜삭제');">찜
								삭제</a>
						</div>

					</li>

				</c:forEach>
			
			<!-- 찜목록이 존재하지 않는다면 -->
			</c:if>
			<c:if test="${fn:length(list) == 0}">
				<h3 style="text-align: center;">찜 목록이 없어요~</h3>
				<br />
				<br />
				<br />
				<br />
			</c:if>
			<button type="button" class="btn btn-primary pull-right" onclick="location.href='/Vada/mainform.do'">메인으로 돌아가기</button>
		</ul>

	</div>

</main>

<jsp:include page="bottom.jsp" />