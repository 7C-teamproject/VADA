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
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception{

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
		
		for (UserDTO userDTO : list) {
			String dbuserid = userDTO.getUserid();
			String dbuserpw = userDTO.getUserpw();
			String dbadminyn = userDTO.getAdminyn();

			if (userid.equals(dbuserid) && userpw.equals(dbuserpw)) {

				session.setAttribute("adminyn", dbadminyn);
				session.setAttribute("userid", userid);
				System.out.println("adminyn===========>" + dbadminyn);

			} else {
//				script.println("<script>");
//				script.println("alert('로그인 실패')");
//				script.println("history.back()");
//				script.println("</script>");
			}
		}

		return "/adminmanageuserform.do";
	}

}
