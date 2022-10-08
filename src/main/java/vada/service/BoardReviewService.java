package vada.service;

import vada.dto.BoardDTO;

public interface BoardReviewService extends BoardService{
	
	public int updateBoardReview(BoardDTO boardDTO) throws Exception;

}
