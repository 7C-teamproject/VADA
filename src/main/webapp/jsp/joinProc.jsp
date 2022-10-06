<%@page import="java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="java.io.PrintWriter"%>
<%@ page import="vada.service.JoinService"%>
<%@ page import="vada.dao.impl.JoinDAOImpl"%>

<jsp:useBean id="userDTO" class="vada.dto.UserDTO" />
<jsp:setProperty name="userDTO" property="*" />
<jsp:setProperty name="userDTO" value="${param.email}@${param.email_add}" property="email" />
<jsp:setProperty name="userDTO" value="no" property="adminyn" />
<jsp:setProperty name="userDTO" value="no" property="blackyn" />

<%
	
	JoinService joinService = new JoinDAOImpl();

	System.out.println(userDTO);
	
	boolean checkuserid = joinService.checkUserid(userDTO.getUserid());
	boolean checknickname = joinService.checkUserid(userDTO.getNickname());
	
	// 비밀번호 영문자+숫자+특수조합(8~25자리 입력) 정규식
	String pwdCheck = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{4,15}$";
	String telCheck = "^[0-9]*$";
	
	PrintWriter script = response.getWriter();
	
	if (userDTO.getUserid() == null || userDTO.getUserpw() == null || 
		userDTO.getName() == null || userDTO.getTel() == null || 
		userDTO.getEmail() == null || userDTO.getAddress() == null || 
		userDTO.getDetailaddress() == null || userDTO.getNickname() == null) {
		script.println("<script>");
		script.println("alert('입력이 안 된 사항이 있습니다.')");
		script.println("history.back()");
		script.println("</script>");
	} 
	else if(!Pattern.matches(pwdCheck, userDTO.getUserpw())){
		script.println("<script>");
		script.println("alert('비밀번호는 영문자+숫자+특수문자 조합으로 4~15자리 사용해야 합니다.')");
		script.println("history.back()");
		script.println("</script>");
	}
	else if(!request.getParameter("pwd").equals(userDTO.getUserpw())) {
		script.println("<script>");
		script.println("alert('비밀번호가 일치하지 않습니다.')");
		script.println("history.back()");
		script.println("</script>");
	}
	else if(!Pattern.matches(telCheck, userDTO.getTel())){
		script.println("<script>");
		script.println("alert('전화번호는 숫자만 입력할 수 있습니다.')");
		script.println("history.back()");
		script.println("</script>");
	}
	else if (checkuserid == false) {
		script.println("<script>");
		System.out.println("userid=========>" + userDTO.getUserid());
		script.println("alert('이미 존재하는 아이디입니다.')");
		script.println("history.back()");
		script.println("</script>");
	} 
	else if (checknickname == false) {
		script.println("<script>");
		System.out.println("userid=========>" + userDTO.getUserid());
		script.println("alert('이미 존재하는 닉네임입니다.')");
		script.println("history.back()");
		script.println("</script>");
	}
	else {
		int result = joinService.join(userDTO);
		script.println("<script>");
		script.println("location.href = '/Vada/jsp/mainForm.jsp'");
		script.println("</script>");
	}
	
	
%>

