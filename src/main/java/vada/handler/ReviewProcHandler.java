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
		
		int productnum = Integer.parseInt(request.getParameter("productnum") == null ? "" : (String) request.getParameter("productnum"));
		 
		boardDTO.setReview(request.getParameter("review"));
		boardDTO.setReviewscore(Integer.parseInt(request.getParameter("reviewscore")));
		boardDTO.setProductnum(productnum);
		
		int result = 0;
		try {
			result = boardReviewService.updateBoardReview(boardDTO);
			
			if(result != 0) {
				System.out.println("후기글 DB에 저장 성공");
			} else {
				System.out.println("후기글 DB에 저장 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/boarddetailform.do?productnum="+productnum;
	}

}
