package vada.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.BoardDeleteDAOImpl;

public class BoardDeleteProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		int productnum = Integer.parseInt((String) request.getParameter("productnum") == null ? "" : (String) request.getParameter("productnum"));
		
		try {
			new BoardDeleteDAOImpl().deleteBoard(productnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/mainform.do";
		
	}

}
