<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="top.jsp" flush="true" />

<main>

	<div class="list con">
		<div class="container">
			<table class="table table-stripped"
				style="text-align: center; boarder: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">중고거래
							게시판</th>
					</tr>
				</thead>
			</table>
		</div>

		<ul class="row" id="test">

			<c:set var="listSize" value="${boardList.size()}" />

			<c:forEach var="item" items="${boardList}" varStatus="stat">

				<li id="listid" class="cell"
					onclick="location.href='/Vada/boarddetailform.do?productnum=${item.productnum}'">
					<div class="img-box">
						<img class=imgfile src="/Vada/img${item.imgsname}" alt="">
					</div>
					<p class="product-price">
						가격 :
						<fmt:formatNumber value="${item.productprice}" pattern="#,###" />
						원
					</p>
					<p class="product-name">${item.title}</p> <c:set var="sysYear">
						<fmt:formatDate value="${item.wdate}"
							pattern="yyyy-MM-dd hh:mm:ss" />
					</c:set>
					<p class="product-date">
						<c:out value="${sysYear}" />
					</p>

				</li>

			</c:forEach>

		</ul>

	</div>

	<div>
		<a id="write" href="/Vada/boardwriteform.do">글 등록</a>
	</div>

</main>

<jsp:include page="bottom.jsp" />