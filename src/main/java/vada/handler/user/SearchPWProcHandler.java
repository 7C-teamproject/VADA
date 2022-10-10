package vada.handler.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.SearchUserPWDAOImpl;
import vada.handler.CommandHandler;
import vada.service.SearchUserPWService;

// 비밀번호 찾기 처리 핸들러
public class SearchPWProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("userid")==null?"":request.getParameter("userid");
		String email = request.getParameter("email")==null?"":request.getParameter("email");

		SearchUserPWService searchUserPWService = new SearchUserPWDAOImpl();

		String userpw = null;
		try {
			// 아이디와 비밀번호 모두 만족하는 userpw 획득
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
	} // process
} // SearchPWProcHandler
