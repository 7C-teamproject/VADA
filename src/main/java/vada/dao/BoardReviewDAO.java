package vada.dao;

import vada.dto.BoardDTO;
import vada.service.BoardReviewService;

public interface BoardReviewDAO extends BoardReviewService{
	
	public int updateBoardReview(BoardDTO boardDTO) throws Exception;

}
