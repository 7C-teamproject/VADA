<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="top.jsp" />

<style>
.con {
	margin-left: auto;
	margin-right: auto;
}
.cell {
	float: left;
	box-sizing: border-box;
	margin-bottom: 20px;
}
.row::after {
	content: "";
	display: block;
	clear: both;
}
.img-box>img {
	display: block;
	width: 100%;
	height: 300px;
}
커스텀 
 html, body {
	overflow-x: hidden;
}
.con {
	max-width: 1000px;
}
.logo-bar {
	text-align: center;
	margin-bottom: 20px;
	margin-top: 20px;
}
.bn-box {
	margin-bottom: 20px;
	margin-top: 20px;
}
@media ( max-width :700px ) {
	.top-bn-box-1 {
		overflow-x: hidden;
	}
	.top-bn-box-1>.img-box {
		margin-left: -50%;
	}
}
.menu-box {
	margin-bottom: 20px;
	margin-top: 20px;
}
.menu-box>ul>li {
	width: calc(100%/ 7);
}
@media ( max-width : 800px) {
	.menu-box {
		display: none;
	}
}
.menu-box>ul>li>a {
	display: block;
	text-align: center;
	font-weight: bold;
	position: relative;
}
.menu-box>ul>li:hover>a {
	color: red;
	text-decoration: underline;
}
.menu-box>ul>li>a::before, .menu-box>ul>li>a::after {
	content: "";
	width: 1px;
	height: 13px;
	background-color: black;
	position: absolute;
	top: 50%;
	transform: translatey(-50%);
	left: 0;
}
.menu-box>ul>li>a::after {
	left: auto;
	right: 0;
}
.menu-box>ul>li:first-child>a::before, .menu-box>ul>li:last-child>a::after
	{
	width: 2px;
}
.list>ul>li {
	width: calc(100%/ 3);
}
.list>ul>li {
	padding: 0 10px;
}
.list>ul {
	margin: 0 -10px;
}
.list>ul>li>.product-name {
	text-align: Center;
	font-weight: bold;
	font-size: 1.5rem;
}
.list>ul>li:hover>.product-name {
	text-decoration: underline;
}
.list>ul>li>.product-price {
	text-align: center;
	font-weight: bold;
	font-size: 1rem;
}
.list>ul>li>.product-date {
	text-align: Center;
}
@media ( max-width : 800px) {
	.list>ul>li {
		width: calc(100%/ 5);
	}
}
@media ( max-width : 650px) {
	.list>ul>li {
		width: calc(100%/ 4);
	}
}
@media ( max-width : 500px) {
	.list>ul>li {
		width: calc(100%/ 3);
	}
}
@media ( max-width : 400px) {
	.list>ul>li {
		width: calc(100%/ 2);
	}
}
</style>

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
			<c:if test="${fn:length(list) != 0}">
				<c:forEach var="item" items="${list}" varStatus="stat">

					<li id="listid" class="cell">
						<div class="img-box">
							<img class=imgfile src="${item.imgsname}" alt="">
						</div>
						<h4>
							가격 :
							<fmt:formatNumber value="${item.productprice}" pattern="#,###" />
							원
						</h4>
						<div class="product-price">
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

			</c:if>
			<c:if test="${fn:length(list) == 0}">
				<h3 style="text-align: center;">찜 목록이 없어요~</h3>
				<br />
				<br />
				<br />
				<br />
			</c:if>
			<button type="button" class="btn btn-primary pull-right"
				onclick="location.href='/Vada/jsp/mainformindex.jsp'">메인으로
				돌아가기</button>
		</ul>

	</div>

</main>

<jsp:include page="bottom.jsp" />