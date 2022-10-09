<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	 alert("회원님의 패스워드는 " + ${userpw} + " 입니다.");
	 location.href="/Vada/jsp/loginForm.jsp";
 </script>