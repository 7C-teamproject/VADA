<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vada.dao.impl.BoardReviewDAOImpl"%>
<%@page import="vada.service.BoardReviewService"%>
<%@ page import="vada.dto.BoardDTO"%>

<jsp:useBean id="boardDTO" class="vada.dto.BoardDTO" />
<jsp:setProperty name="boardDTO" property="*" />

<%
    
  	BoardReviewService boardReviewService = new BoardReviewDAOImpl();
	
// 	int reviewProductNum = Integer.parseInt(request.getParameter("productnum")); // 게시물 ID 얻기
// 	int buyerid = boardReviewService.reviewBoard(boardDTO, reviewProductNum); 
	
	int result = boardReviewService.reviewBoard(boardDTO);
	
	
	response.sendRedirect("/Vada/jsp/boardDetailForm.jsp?productnum="+request.getParameter("productnum"));
%>