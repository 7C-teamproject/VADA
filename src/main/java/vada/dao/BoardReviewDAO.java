package vada.dao;

import vada.dto.BoardDTO;
import vada.service.BoardReviewService;

public interface BoardReviewDAO extends BoardReviewService{
	
	public abstract int updateBoardReview(BoardDTO boardDTO) throws Exception;

}
