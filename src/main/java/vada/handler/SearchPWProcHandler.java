package vada.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.SearchUserPWDAOImpl;
import vada.service.SearchUserPWService;

public class SearchPWProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("userid");
		String email = request.getParameter("email");

		SearchUserPWService searchUserPWService = new SearchUserPWDAOImpl();

		String userpw = null;
		try {
			userpw = searchUserPWService.searchUserPW(userid, email);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String url = "";

		if (userpw == null) {
			url = "jsp/failedFindPW.jsp";

		} else {
			url = "jsp/findPWLogin.jsp?searchUserpw=" + userpw;

		}
		return url;
	}
}
