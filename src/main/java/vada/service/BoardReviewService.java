package vada.service;

import vada.dto.BoardDTO;

public interface BoardReviewService extends BoardService{
	
	public int reviewBoard(BoardDTO boardDTO) throws Exception;

}
