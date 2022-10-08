package vada.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.BoardSearchListDAOImpl;

public class SearchResultFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String cate1 = request.getParameter("categories1") == null ? "" : request.getParameter("categories1");
		String cate2 = request.getParameter("categories2") == null ? "" : request.getParameter("categories2");
		String searchText = request.getParameter("searchText") == null ? "" : request.getParameter("searchText");

		List<Map> list = null;
		try {
			list = new BoardSearchListDAOImpl().searchBoard(cate1, cate2, searchText);
		} catch (Exception e) {
			e.printStackTrace();
		}// 사용자가 입력한 검색어에 해당하는 결과를 가진
																							// 리스트

		request.setAttribute("list", list); 
		return "/jsp/searchResultForm.jsp";
	}

}
