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
		String userid = (String) request.getParameter("userid")==null?"":(String) request.getParameter("userid");
		String userpw = (String) request.getParameter("userpw")==null?"":(String) request.getParameter("userpw");

		LoginService loginService = new LoginDAOImpl();

		List<UserDTO> list = loginService.userLogin(userid, userpw);

		boolean flag = false;
		String dbuserid = null;
		String dbuserpw = null;
		String dbusernickname = null;
		String adminyn = null;
		String blackyn = null;
		String url = "";

		for (UserDTO userDTO : list) {
			dbuserid = userDTO.getUserid();
			dbuserpw = userDTO.getUserpw();
			dbusernickname = userDTO.getNickname();
			adminyn = userDTO.getAdminyn();
			blackyn = userDTO.getBlackyn();

			if (userid.equals(dbuserid) && userpw.equals(dbuserpw)) {
				flag = true;
				System.out.println("nickname===========>" + dbusernickname);
			}
		}

		// 로그인 성공 시
		if (flag) {
			
			// 로그인한 사용자가 블랙 리스트로 등록된 아이디면 로그인 불가능
//			if (blackyn.equals("yes")) {
//				url = "/jsp/blackIdLogin.jsp";
//			} else { // 블랙 리스트 회원이 아닌 일반 사용자 로그인 성공 시
				session.setAttribute("dbusernickname", dbusernickname);
				session.setAttribute("userid", userid);
				session.setAttribute("adminyn", adminyn);
				url = "/mainform.do";
//			}

		} else { // 로그인 실패 시
			url = "/jsp/failedLogin.jsp";
		}

		return url;
	}

}
