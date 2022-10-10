package vada.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.BoardListDAOImpl;
import vada.service.BoardListService;

// 관리자만 확인할 수 있는 신고목록 폼 핸들러
public class AdminManageNotifyFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		BoardListService notifyListService = new BoardListDAOImpl();
		try {
			// 신고목록 request에 저장
			request.setAttribute("list", notifyListService.notifyListBoard());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/jsp/adminManageNotifyForm.jsp";
	}
}
