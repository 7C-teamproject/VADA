package vada.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vada.dao.impl.ManagerDAOImpl;
import vada.dto.UserDTO;
import vada.service.ManagerService;

public class AdminManageUserFormHandler implements CommandHandler {

	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ManagerService managerService = new ManagerDAOImpl();

		HttpSession session = request.getSession();
		
		String userid = (String) session.getAttribute("userid") == null ? "" : request.getParameter("userid");
		if (userid == "") {
			System.out.println("관리자로 로그인 해야함");
		}

		List<UserDTO> list = null;
		try {
			list = managerService.listBoard();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // TODO useridparam 필요한지 확인

		request.setAttribute("list", list);
		
		
		return "/jsp/adminManageUserForm.jsp";
	}
}
