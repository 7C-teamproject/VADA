<%@page import="com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream"%>
<%@page import="vada.service.SoldOutService"%>
<%@page import="vada.dao.impl.SoldOutDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	
	String productnum = request.getParameter("productnum")==null? "" : request.getParameter("productnum");;
	String reserveid = request.getParameter("reserveid")==null? "" : request.getParameter("reserveid");
	
	SoldOutService soldOutService = new SoldOutDAOImpl();
	
	int result = soldOutService.soldOut(reserveid , Integer.parseInt(productnum)); // TODO 로그인 세션 구현 후 바꿔야함
	
	if (result != 0) {
		System.out.println("db결과 반영 성공");
	} else {
		System.out.println("실패");
	}
	
	response.sendRedirect("/Vada/jsp/boardDetailForm.jsp?productnum="+productnum);
%>

<!-- <script> -->
// 	function soldout() {
// 		var returnValue = confirm('후기를 작성하시겠습니까?');
// 		if (returnValue) {
// 			location.href = '/Vada/jsp/reviewForm.jsp';
// 		} else {
// 			location.href = '/Vada/jsp/mainForm.jsp';
// 		}
// 	}
<!-- </script> -->