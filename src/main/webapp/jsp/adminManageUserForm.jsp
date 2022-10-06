<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="vada.dto.UserDTO"%>
<%@ page import="com.mysql.cj.protocol.a.NativeConstants.StringLengthDataType"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="vada.service.ManagerService"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="vada.dao.impl.ManagerDAOImpl"%>
<%@ page import="vada.dao.ManagerDAO"%>
<%@ page import="vada.dao.LoginDAO"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="top.jsp" />

<style>
th, td {
	border: 1px solid #000000;
	text-align: center;
}
</style>


<%
// ManagerService managerService = new ManagerDAOImpl();

// //	String useridparam = "YEO";
// String userid = (String)session.getAttribute("userid") == null ? "" : request.getParameter("userid");
// if(userid=="") {
// 	System.out.println("관리자로 로그인 해야함");
// 	response.sendRedirect("/Vava/jsp/adminLoginForm.jsp");
// }

// List<UserDTO> list = managerService.listBoard(); // TODO useridparam 필요한지 확인

// 	pageContext.setAttribute("list", list);
	
%>

<script src="http://code.jquery.com/jquery-latest.js"></script>

<main>

	<div class="container-fluid px-4">
		<ol class="breadcrumb mb-4">
		</ol>
		<div class="card mb-4">
			<div class="card-header">
				<i class="fas fa-table me-1"></i> 회원목록
			</div>
			<div class="card-body">
			
				<form action="/Vada/blacklistproc.do" method="Post">
				
					<table>
						<colgroup>
							<col width="500px" />
							<col width="1500px" />
							<col width="500px" />
						</colgroup>
						
						<thead>
							<tr>
								<th>회원ID</th>
								<th>가입일자</th>
								<th>블랙리스트</th>
							</tr>
						</thead>

						<tbody>
							<input type="hidden" name="listsize" value="${list.size()}" />
							<c:forEach var="userinfo" items="${list}" varStatus="status">
								<tr>
									<td><input type="hidden" name="${status.index}" value="${userinfo.userid}" />${userinfo.userid}</td>
									<td>${userinfo.joindate}</td>
									<td><input type="checkbox" id="${status.index}" name="checkbox" value="${userinfo.blackyn}"
										<c:if test="${userinfo.blackyn eq 'yes'}">checked</c:if>> 
										<span id="blackyn${status.index}">${userinfo.blackyn}</span></td>
								</tr>
								<input type="hidden" name="blackyn${status.index}" id="blackynparam${status.index}" value="${userinfo.blackyn}" />
								
								<script>
									$(document).ready(function() {
										$("#${status.index}").change(function() {
											if ($("#${status.index}").is(":checked")) {
												$("#blackyn${status.index}").text("yes");
												$("#blackynparam${status.index}").val("yes");
											} else {
												$("#blackyn${status.index}").text("no");
												$("#blackynparam${status.index}").val("no");
											}
										});
									});
								</script>
								
							</c:forEach>
						</tbody>
						
					</table>

					<input type="button" value="회원 정보 수정" onclick="this.form.submit()" />
					
				</form>
				
			</div>
		</div>
			<a href = "/Vada/adminmanagenotifyform.jsp">신고글 관리페이지 이동</a>
	</div>

</main>



<jsp:include page="bottom.jsp" />