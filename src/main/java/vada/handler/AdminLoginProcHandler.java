package vada.handler;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vada.dao.impl.LoginDAOImpl;
import vada.dto.UserDTO;
import vada.service.LoginService;

// 관리자 로그인 처리 핸들러
public class AdminLoginProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		String userid = request.getParameter("aduserid") == null ? "" : request.getParameter("aduserid");
		String userpw = request.getParameter("aduserpw") == null ? "" : request.getParameter("aduserpw");

		LoginService loginService = new LoginDAOImpl();

		UserDTO userDTO = null;

		try {
			// userid와 userpw에 맞는 관리자 데이터를 받아옴
			userDTO = loginService.adminynLogin(userid, userpw);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String url = "";

		// 만약 관리자 아이디가 있다면
		if (userid.equals(userDTO.getUserid()) && userpw.equals(userDTO.getUserpw())) {
			url = "/adminmanageuserform.do";
			session.setAttribute("adminyn", userDTO.getAdminyn());
			session.setAttribute("userid", userid);
		// 매칭되는 관리자 아이디가 없다면
		} else {
			url = "/jsp/adminFailedLogin.jsp";
		}

		return url;
	} // process

} // AdminLoginProcHandler