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
	int notifyid = Integer.parseInt(request.getParameter("notifyid") == null ? "" : (String) request.getParameter("notifyid"));

	// 게시물 데이터 삭제
	new BoardDeleteDAOImpl().deleteNotify(notifyid);
	
	response.sendRedirect("/Vada/jsp/adminManageNotifyForm.jsp");
%>

