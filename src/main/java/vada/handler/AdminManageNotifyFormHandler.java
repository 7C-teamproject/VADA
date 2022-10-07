package vada.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.BoardListDAOImpl;
import vada.service.BoardListService;

public class AdminManageNotifyFormHandler implements CommandHandler{
@Override
public String process(HttpServletRequest request, HttpServletResponse response) {
	BoardListService notifyListService = new BoardListDAOImpl();
	   try {
		request.setAttribute("list", notifyListService.notifyListBoard());
	} catch (Exception e) {
		e.printStackTrace();
	}
	return "/Vada/adminmanagenotifyform.jsp";
}
}
