package vada.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.SearchUserIDDAOImpl;
import vada.service.SearchUserIDService;

public class SearchIDProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email")==null?"":request.getParameter("email");
		String name = request.getParameter("username")==null?"":request.getParameter("username");

		SearchUserIDService searchUserIDService = new SearchUserIDDAOImpl();

		String userid = null;
		try {
			userid = searchUserIDService.searchUserID(name, email);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String url = "";

		if (userid == null) {
			url = "jsp/failedFindID.jsp";

		} else {
			url = "jsp/findIDLogin.jsp?searchUserid=" + userid;
		}
		
		return url;
	}
}
