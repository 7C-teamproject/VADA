package vada.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.BoardReviewDAOImpl;
import vada.dto.BoardDTO;
import vada.service.BoardReviewService;

public class ReviewProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		BoardReviewService boardReviewService = new BoardReviewDAOImpl();
		BoardDTO boardDTO = new BoardDTO();
		int productnum = Integer.parseInt(request.getParameter("productnum"));
		
		boardDTO.setReview(request.getParameter("review"));
		boardDTO.setReviewscore(Integer.parseInt(request.getParameter("reviewscore")));
		boardDTO.setProductnum(productnum);
		
		
		try {
			int result = boardReviewService.reviewBoard(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/boarddetailform.do?productnum="+productnum;
	}

}
