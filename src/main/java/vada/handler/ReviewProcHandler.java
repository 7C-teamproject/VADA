package vada.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.BoardReviewDAOImpl;
import vada.dto.BoardDTO;
import vada.service.BoardReviewService;

public class ReviewProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDTO boardDTO = new BoardDTO();
		
		boardDTO.setReview(request.getParameter("review"));
		boardDTO.setReviewscore(Integer.parseInt(request.getParameter("reviewscore")));
		
	  	BoardReviewService boardReviewService = new BoardReviewDAOImpl();
		
		try {
			int result = boardReviewService.reviewBoard(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "boarddetailform.do";
	}

}
