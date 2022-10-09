<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	alert("회원님의 아이디는 <%=request.getParameter("searchUserpw")%> 입니다.");
	location.href="/Vada/jsp/loginForm.jsp"
</script>