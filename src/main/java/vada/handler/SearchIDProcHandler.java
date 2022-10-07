package vada.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.SearchUserIDDAOImpl;
import vada.service.SearchUserIDService;

public class SearchIDProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		SearchUserIDService searchUserIDService = new SearchUserIDDAOImpl();

		String userid = null;
		try {
			userid = searchUserIDService.searchUserID(name, email);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String url = "";

		if (userid == null) {
			url = "";

		} else {
			url="/";
//		    	   script.println("<script>");
//			   		script.println("alert('회원님의 아이디는 "+userid+" 입니다.')");
//			   		script.println("location.href='/Vada/jsp/loginForm.jsp'");
//			   		script.println("</script>");

		}
		return "/loginform.do";
	}
}
