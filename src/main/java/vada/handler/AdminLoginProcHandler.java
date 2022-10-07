package vada.handler;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vada.dao.impl.LoginDAOImpl;
import vada.dto.UserDTO;
import vada.service.LoginService;

public class AdminLoginProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String userid = request.getParameter("aduserid");
		String userpw = request.getParameter("aduserpw");

		LoginService loginService = new LoginDAOImpl();

		List<UserDTO> list=null;
		PrintWriter script = null;
		try {
			list = loginService.adminynLogin(userid, userpw);
			script = response.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String url = "";
		for (UserDTO userDTO : list) {
			String dbuserid = userDTO.getUserid();
			String dbuserpw = userDTO.getUserpw();
			String dbadminyn = userDTO.getAdminyn();

			if (userid.equals(dbuserid) && userpw.equals(dbuserpw)) {
				url = "/adminmanageuserform.do";
				session.setAttribute("adminyn", dbadminyn);
				session.setAttribute("userid", userid);
				System.out.println("adminyn===========>" + dbadminyn);

			} else {
				url = "/jsp/adminfailedLogin.jsp";
			}
		}

		return url;
	}

}