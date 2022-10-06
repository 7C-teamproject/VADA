<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="vada.dto.UserDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="vada.dao.impl.LoginDAOImpl"%>
<%@ 
page import="vada.service.LoginService"%>

<%
// 	String userid = request.getParameter("userid");
// 	String userpw = request.getParameter("userpw");
	
// 	LoginService loginService = new LoginDAOImpl();
	
// 	List<UserDTO> list = loginService.userLogin(userid, userpw);
	
// 	boolean flag = false;
// 	String dbuserid = null;
// 	String dbuserpw = null;
// 	String dbusernickname = null;
// 	String adminyn = null;
	
// 	for (UserDTO userDTO : list) {
// 		dbuserid = userDTO.getUserid();
// 		dbuserpw = userDTO.getUserpw();
// 		dbusernickname = userDTO.getNickname();
// 		adminyn = userDTO.getAdminyn();
	
// 		if (userid.equals(dbuserid) && userpw.equals(dbuserpw)) {
// 			flag = true;
// 			System.out.println("nickname===========>" + dbusernickname);
// 		}
// 	}
	
// 	PrintWriter script = response.getWriter();
	
// 	if (flag) { // 로그인 성공 시
// 		response.sendRedirect("/Vada/jsp/mainForm.jsp");

// 		session.setAttribute("usernickname", dbusernickname);
// 		session.setAttribute("userid", userid);
// 		session.setAttribute("adminyn", adminyn);
// 	} else { // 로그인 실패 시
// 		script.println("<script>");
// 		script.println("alert('로그인 실패')");
// 		script.println("history.back()");
// 		script.println("</script>");
// 	}
	
	
	
%>