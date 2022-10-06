package vada.dao;

import vada.dto.BoardDTO;
import vada.service.BoardReviewService;

public interface BoardReviewDAO extends BoardReviewService{
	
	public int reviewBoard(BoardDTO boardDTO) throws Exception;

}
