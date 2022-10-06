<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="vada.dto.UserDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="vada.dao.impl.LoginDAOImpl"%>
<%@ 
page import="vada.service.LoginService"%>

<%
	
	String userid = request.getParameter("aduserid");
	String userpw = request.getParameter("aduserpw");
	
	LoginService loginService = new LoginDAOImpl();
	
	List<UserDTO> list = loginService.adminynLogin(userid, userpw);
	PrintWriter script = response.getWriter();
	
	for (UserDTO userDTO : list) {
		String dbuserid = userDTO.getUserid();
		String dbuserpw = userDTO.getUserpw();
		String dbadminyn = userDTO.getAdminyn();
	
		if (userid.equals(dbuserid) && userpw.equals(dbuserpw)) {
	
			session.setAttribute("adminyn", dbadminyn);
			session.setAttribute("userid", userid);
	
			response.sendRedirect("/Vada/jsp/adminManageUserForm.jsp");
	
			System.out.println("adminyn===========>" + dbadminyn);
	
		} else {
			script.println("<script>");
			script.println("alert('로그인 실패')");
			script.println("history.back()");
			script.println("</script>");
	
		}
	}
%>