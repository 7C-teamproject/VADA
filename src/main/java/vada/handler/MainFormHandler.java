package vada.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.BoardListDAOImpl;
import vada.service.BoardListService;

public class MainFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		// 검색어 파라미터
		String bCateParam = request.getParameter("bCate") == null ? "" : request.getParameter("bCate");
		String searchTextParam = request.getParameter("searchText") == null ? "" : request.getParameter("searchText");

		// 게시글 출력
		BoardListService boardListService = new BoardListDAOImpl();

		List<Map> list = null;
		
		try {
			list = boardListService.listBoard(bCateParam, searchTextParam);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("list", list);
		
		return "jsp/mainForm.jsp";
	}
	
}
