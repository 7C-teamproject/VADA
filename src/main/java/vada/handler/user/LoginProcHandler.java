package vada.handler.user;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vada.dao.impl.LoginDAOImpl;
import vada.dto.UserDTO;
import vada.handler.CommandHandler;
import vada.service.LoginService;

// 로그인 처리 핸들러
public class LoginProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		String userid = (String) request.getParameter("userid") == null ? "" : (String) request.getParameter("userid");
		String userpw = (String) request.getParameter("userpw") == null ? "" : (String) request.getParameter("userpw");

		LoginService loginService = new LoginDAOImpl();

		// 매칭된 유저정보를 userDTO에 저장
		UserDTO userDTO = null;
		userDTO = loginService.userLogin(userid, userpw);

		String url = "";


		// 유저 정보가 존재한다면
		if (userDTO==null) {
			url = "/jsp/failedLogin.jsp";
		}

		else if (userDTO!=null) {
			if (userDTO.getBlackyn().equals("yes")) {
				url = "/jsp/user/blackIDLogin.jsp";

				// 블랙 리스트 회원이 아닌 일반 사용자 로그인 성공 시
			} else {
				request.setAttribute("msg", "로그인에 성공하셨습니다.");
				session.setAttribute("dbusernickname", userDTO.getNickname());
				session.setAttribute("userid", userDTO.getUserid());
				session.setAttribute("adminyn", userDTO.getAdminyn());
				url = "/mainform.do";
			}
		}

		return url;
	} // process

} // LoginProcHandler
