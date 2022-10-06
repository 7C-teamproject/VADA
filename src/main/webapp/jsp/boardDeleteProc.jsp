<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="vada.dao.impl.BoardImgDeleteDAOImpl"%>
<%@ page import="java.io.File"%>
<%@ page import="vada.dao.impl.BoardImgListDAOImpl"%>
<%@ page import="vada.dto.ImgDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="vada.dao.impl.BoardDeleteDAOImpl"%>


<%
	// 삭제할 게시물 productnum
	int productnum = Integer.parseInt((String) request.getParameter("productnum") == null ? "" : (String) request.getParameter("productnum"));

	// 게시물 데이터 삭제
	new BoardDeleteDAOImpl().deleteBoard(productnum);
	
	response.sendRedirect("/Vada/jsp/mainForm.jsp");
%>

