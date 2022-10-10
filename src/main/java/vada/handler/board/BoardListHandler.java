package vada.handler.board;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.board.crud.BoardListDAOImpl;
import vada.handler.CommandHandler;
import vada.service.board.crud.BoardListService;
 
// 메인 폼 핸들러
public class BoardListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		// 게시글 출력
		BoardListService boardListService = new BoardListDAOImpl();

		List<Map<String, Object>> boardList = null;
		
		try {
			// 모든 게시글 리스트 저장
			boardList = boardListService.getBoardList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("boardList", boardList);
		
		return "/jsp/board/mainForm.jsp";
		
	} // process
	
} // MainFormHandler