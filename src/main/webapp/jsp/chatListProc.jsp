<%@page import="vada.dao.impl.ChatDAOImpl"%>
<%@page import="vada.service.ChatService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<jsp:useBean id="boardDTO" class="vada.dto.BoardDTO"  />

<jsp:setProperty name="boardDTO" property="*" />

<%
pageContext.setAttribute("boardDTO",boardDTO);

ChatService chatService =new ChatDAOImpl();


//chatService.ktchatBoard( ${boardDTO.product} , boardDTO);
//chatService.ktchatBoard(productnum, ktuserchatroomDTO)
 %>