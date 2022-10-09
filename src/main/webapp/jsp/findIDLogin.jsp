<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 회원ID 찾았을때 ID alert 출력을 위한 jsp -->
<script>
	alert("회원님의 아이디는 <%=request.getParameter("searchUserid")%> 입니다.");
	location.href="/Vada/jsp/loginForm.jsp"
</script>
