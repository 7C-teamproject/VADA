<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="javax.websocket.SendResult"%>
<%@ page import="vada.dao.impl.ManagerDAOImpl"%>
<%@ page import="vada.service.ManagerService"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>

<%
	int listsize = Integer.parseInt(request.getParameter("listsize"));
	System.out.println("listsize====>" + listsize);

	for (int i = 0; i < listsize; i++) {
		String buyerid = (String) request.getParameter(String.valueOf(i)); // testid1, testid2, testid3~~~
		String blackyn = (String) request.getParameter("blackyn" + String.valueOf(i)); // no, yes, no, no ~~
	
		ManagerService managerService = new ManagerDAOImpl();
		int result = managerService.blackList(buyerid, blackyn);

		if (result != 0) {
			System.out.println("블랙리스트 여부 디비에 저장 성공!!!!!!!!!");
		} else {
			System.out.println("블랙리스트 여부 디비에 저장 실패!!!!!!!!!");
		}
		
		System.out.println("buyerid====>" + buyerid + "  blackyn====>" + blackyn);
	}
	
	response.sendRedirect("adminManageUserForm.jsp");

%>

