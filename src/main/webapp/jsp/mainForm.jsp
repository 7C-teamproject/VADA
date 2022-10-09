<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="top.jsp" flush="true" />

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
#write {
	width: 80px;
	height: 80px;
	position: fixed;
	background: gray;
	text-align: center;
	color: white;
	font-style: inherit;
	line-height: 80px;
	right: 0;
	bottom: 0;
	text-decoration: none;
	margin-bottom: 100px;
	margin-right: 60px;
	border-radius: 50%;
}
</style>

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