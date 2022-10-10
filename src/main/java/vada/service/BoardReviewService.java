package vada.service;

import vada.dto.BoardDTO;

public interface BoardReviewService extends BoardService{
	
	public abstract int updateBoardReview(BoardDTO boardDTO) throws Exception;

}
