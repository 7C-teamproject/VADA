package vada.handler;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.BoardListDAOImpl;
import vada.service.BoardListService;
 
public class MainFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		// 게시글 출력
		BoardListService boardListService = new BoardListDAOImpl();

		List<Map> boardList = null;
		
		try {
			boardList = boardListService.getBoardList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("boardList", boardList);
		
		return "jsp/mainForm.jsp";
	}
	
}
