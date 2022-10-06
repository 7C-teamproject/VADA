package vada.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.BoardListDAOImpl;
import vada.service.BoardListService;

public class BoardListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		String bCateParam = request.getParameter("bCate") == null ? "" : request.getParameter("bCate");
		String searchTextParam = request.getParameter("searchText") == null ? "" : request.getParameter("searchText");

		BoardListService boardListService = new BoardListDAOImpl();

		try {
			request.setAttribute("list", boardListService.listBoard(bCateParam, searchTextParam));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		request.setAttribute("bCateParam", bCateParam);
		request.setAttribute("boardListService", boardListService);

		return "/jsp/mainForm.jsp";
	}

} // class
