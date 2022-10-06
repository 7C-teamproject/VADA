<%@page import="java.io.PrintWriter"%>
<%@page import="vada.dao.impl.SearchUserPWDAOImpl"%>
<%@page import="vada.service.SearchUserPWService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    
    String userid = request.getParameter("userid");
    String email = request.getParameter("email");
    
    SearchUserPWService searchUserPWService = new SearchUserPWDAOImpl();
    
    String userpw = searchUserPWService.searchUserPW(userid, email);  
    
	   
	PrintWriter script = response.getWriter();
	
       if(userpw == null){
    	  
    	   script.println("<script>");
	   		script.println("alert('일치하는 회원이 존재하지 않습니다.')");
	   		script.println("history.back()");
	   		script.println("</script>");
    	   
       }else{
    	   
    	   script.println("<script>");
	   		script.println("alert('회원님의 비밀번호는 "+userpw+" 입니다.')");
	   		script.println("location.href='/Vada/jsp/loginForm.jsp'");
	   		script.println("</script>");
       }
    
    %>