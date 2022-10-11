package vada.handler.board.func;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.board.func.BoardSearchListDAOImpl;
import vada.handler.CommandHandler;

// 검색결과를 보여주는 검색 결과 폼 핸들러
public class CategoryBoardFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		List<Map<String, Object>> list = null;
		try {
			// 상/하위 카테고리 및 검색어 키워드에 맞는 데이터를 list에 저장
			list = new BoardSearchListDAOImpl().searchCateBoard(Integer.parseInt(request.getParameter("category")));
		} catch (Exception e) {
			e.printStackTrace();
		}// 사용자가 입력한 검색어에 해당하는 결과를 가진 리스트
		
		System.out.println("@@@@@@@categorynum@@@@@@@"+request.getParameter("category"));

		request.setAttribute("list", list); 
		return "/jsp/board/func/categoryBoardForm.jsp";
	} // process

} // SearchResultFormHandler
