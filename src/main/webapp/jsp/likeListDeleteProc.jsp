<%@page import="vada.dao.impl.LikeListDeleteDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%
   // 삭제할 게시물 productnum
   int productnum = Integer.parseInt((String) request.getParameter("productnum") == null ? "" : (String) request.getParameter("productnum"));

   // 게시물 데이터 삭제
   String userid = (String)session.getAttribute("userid");
   new LikeListDeleteDAOImpl().likeDelete(userid, productnum);
   
   
   response.sendRedirect("/Vada/jsp/likeListForm.jsp");
%>