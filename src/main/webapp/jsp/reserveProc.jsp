<%@page import="vada.dao.impl.BoardViewDAOImpl"%>
<%@page import="vada.service.BoardViewService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int productnum = Integer.parseInt(request.getParameter("productnum"));
	String userid = (String)session.getAttribute("userid");
	String command = request.getParameter("command") == null ? "" : request.getParameter("command");
	
	System.out.println("@@@@@@@@@@"+command);
	
	int result = new BoardViewDAOImpl().reserveBoard(productnum,command,userid); //TODO 나중 수정
	
	response.sendRedirect("/Vada/jsp/boardDetailForm.jsp?productnum="+productnum);

%>