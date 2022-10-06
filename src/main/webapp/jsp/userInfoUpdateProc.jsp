<%@page import="vada.dto.UserDTO"%>
<%@page import="vada.dao.impl.UserInfoUpdateDAOImpl"%>
<%@page import="vada.service.UserInfoUpdateservice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <jsp:useBean id="userDTO"  class="vada.dto.UserDTO" />
    <jsp:setProperty name="userDTO"  property="*" />     
    
    <% 
    
UserInfoUpdateservice userInfoUpdateservice = new UserInfoUpdateDAOImpl();
    String userid=(String)session.getAttribute("userid");
    System.out.println("UserDTO Proc.jsp : " + userDTO);
    
    userInfoUpdateservice.UserInfoUpdate(userid, userDTO);

    RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/loginForm.jsp");
	dispatcher.forward(request, response);

%>