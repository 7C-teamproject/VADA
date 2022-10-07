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
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception{

		HttpSession session = request.getSession();
		String userid = (String) request.getParameter("userid");
		String userpw = (String) request.getParameter("userpw");
		
		LoginService loginService = new LoginDAOImpl();
		
		List<UserDTO> list = loginService.userLogin(userid, userpw);
		
		boolean flag = false;
		String dbuserid = null;
		String dbuserpw = null;
		String dbusernickname = null;
		String adminyn = null;
		
		
		for (UserDTO userDTO : list) {
			dbuserid = userDTO.getUserid();
			dbuserpw = userDTO.getUserpw();
			dbusernickname = userDTO.getNickname();
			adminyn = userDTO.getAdminyn();
		
			if (userid.equals(dbuserid) && userpw.equals(dbuserpw)) {
				flag = true;
				System.out.println("nickname===========>" + dbusernickname);
			}
		}
		
		String url = "";
		if (flag) { // 로그인 성공 시

			session.setAttribute("usernickname", dbusernickname);
			session.setAttribute("userid", userid);
			session.setAttribute("adminyn", adminyn);
			url = "/mainform.do";
			
		} else { // 로그인 실패 시
//			
			url = "jsp/failedLogin.jsp";
		}
		
		return url;
	}
	
	
}
