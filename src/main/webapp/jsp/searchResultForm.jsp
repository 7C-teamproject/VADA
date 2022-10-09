<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="top.jsp" />

<main>

	<div class="container">
		<table class="table table-stripped"
			style="text-align: center; boarder: 1px solid #dddddd">
			<thead>
				<tr>
					<th colspan="2"
						style="background-color: #eeeeee; text-align: center;">'${param.searchText}'
						검색결과</th>
				</tr>
			</thead>
		</table>
	</div>

	<div class="list con">
		<ul class="row" id="test">

			<c:set var="listSize" value="${list.size()}" />
			<c:if test="${fn:length(list) != 0}">
				<c:forEach var="item" items="${list}" varStatus="stat">
					<li id="listid" class="cell" onclick="location.href='/Vada/boarddetailform.do?productnum=${item.productnum}'">
						<div class="img-box">
							<img class=imgfile src="/Vada/img${item.imgsname}">

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
				</c:forEach>


			</c:if>
			<c:if test="${fn:length(list) == 0}">
				<h3 style="text-align: center;">'${param.searchText}' 검색결과 없음</h3>
			</c:if>

		</ul>
	</div>
	<div>
		<a href="/Vada/jsp/mainformindex.jsp" class="btn btn-secondary"
			style="float: right;">메인화면으로 돌아가기</a>
	</div>

</main>

<jsp:include page="bottom.jsp" />