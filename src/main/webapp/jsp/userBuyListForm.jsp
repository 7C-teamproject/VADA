<%@page import="java.util.List"%>
<%@page import="vada.dto.BoardDTO"%>
<%@page import="vada.dao.impl.BuyListDAOImpl"%>
<%@page import="vada.service.BuyListSerive"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="top.jsp" />

<style>
th, td {
	border: 1px solid #000000;
	text-align: center;
}
</style>

<main>

	<div class="container-fluid px-4">
		<h1 class="mt-4">구매 목록</h1>
		<ol class="breadcrumb mb-4">
		</ol>

		<div class="card mb-4">
			<div class="card-header">
				<i class="fas fa-table me-1"></i> Buy List
			</div>
			<div class="card-body">
				<table>
					<colgroup>
						<col width="3000px" />
						<col width="600px" />
						<col width="160px" />
					</colgroup>
					<thead>
						<tr>
							<th>게시물 제목</th>
							<th>구매일자</th>
							<th>후기작성</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="boardDTO" items="${list}" varStatus="stat">
							<tr>
								<td>${boardDTO.title}</td>
								<td>${boardDTO.soldoutdate}</td>
								<td>
			 <script src="/Vada/js/common.js"></script>
   <a class="btn btn-secondary"  style="float: right;" href="javascript:confirmCommand('/Vada/reviewform.do?productnum=${boardDTO.productnum}','후기작성');">후기작성</a>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<a href="/Vada/jsp/mainformindex.jsp" class="btn btn-secondary" style="float:right;">메인화면으로 돌아가기</a>
	</div>

</main>

<jsp:include page="bottom.jsp" />