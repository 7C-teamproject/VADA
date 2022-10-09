package vada.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vada.dao.impl.BoardDetailDAOImpl;

public class ReserveprocHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		int productnum = Integer.parseInt(request.getParameter("productnum") == null ? "" : (String) request.getParameter("productnum"));
		
		String userid = (String) session.getAttribute("userid");
		String command = request.getParameter("command") == null ? "" : request.getParameter("command");

		System.out.println("@@@@@@@@@@" + command);

		try {
			int result = new BoardDetailDAOImpl().reserveBoard(productnum, command, userid);
		} catch (Exception e) {
			e.printStackTrace();
		} // TODO 나중 수정

		return "boarddetailform.do";
	}

}
