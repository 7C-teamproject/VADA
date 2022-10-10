package vada.handler;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vada.dao.impl.LoginDAOImpl;
import vada.dto.UserDTO;
import vada.service.LoginService;

public class LoginProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		String userid = (String) request.getParameter("userid") == null ? "" : (String) request.getParameter("userid");
		String userpw = (String) request.getParameter("userpw") == null ? "" : (String) request.getParameter("userpw");

		LoginService loginService = new LoginDAOImpl();

		UserDTO userDTO = loginService.userLogin(userid, userpw);
		
		String url = "";

		if (userid.equals(userDTO.getUserid()) && userpw.equals(userDTO.getUserpw())) {
			if (userDTO.getBlackyn().equals("yes")) {
				url = "/jsp/blackIdLogin.jsp";
			} else { // 블랙 리스트 회원이 아닌 일반 사용자 로그인 성공 시
			session.setAttribute("dbusernickname", userDTO.getNickname());
			session.setAttribute("userid", userDTO.getUserid());
			session.setAttribute("adminyn", userDTO.getAdminyn());
			url = "/mainform.do";
			}
		}
		else { // 로그인 실패 시
			url = "/jsp/failedLogin.jsp";
		}

		return url;
	}

}
