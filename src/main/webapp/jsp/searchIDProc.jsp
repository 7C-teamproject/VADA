<%@page import="java.io.PrintWriter"%>
<%@page import="vada.dao.impl.SearchUserIDDAOImpl"%>
<%@page import="vada.service.SearchUserIDService"%>
<%@page import="vada.dao.impl.LoginDAOImpl"%>
<%@page import="vada.dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="vada.service.LoginService"%>
<%@page import="java.nio.file.attribute.UserPrincipalLookupService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    
    SearchUserIDService searchUserIDService = new SearchUserIDDAOImpl();

    
    String userid = searchUserIDService.searchUserID(name, email);
    
	
	PrintWriter script = response.getWriter();
	
       if(userid == null){
    	  
    	   script.println("<script>");
	   		script.println("alert('일치하는 회원이 존재하지 않습니다.')");
	   		script.println("history.back()");
	   		script.println("</script>");
    	   
       }else{
    	   
    	   script.println("<script>");
	   		script.println("alert('회원님의 아이디는 "+userid+" 입니다.')");
	   		script.println("location.href='/Vada/jsp/loginForm.jsp'");
	   		script.println("</script>");
       }
    
    %>