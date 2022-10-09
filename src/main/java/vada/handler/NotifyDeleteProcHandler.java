package vada.handler;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.BoardDeleteDAOImpl;

public class NotifyDeleteProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		// 삭제할 게시물 productnum
		int notifyid = Integer.parseInt(request.getParameter("notifyid") == null ? "" : (String) request.getParameter("notifyid"));

		// 게시물 데이터 삭제
		try {
			new BoardDeleteDAOImpl().deleteNotify(notifyid);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/adminmanagenotifyform.do";

	}

}
