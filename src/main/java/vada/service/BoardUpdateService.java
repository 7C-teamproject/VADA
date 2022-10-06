package vada.service;

import vada.dto.BoardDTO;
import vada.dto.CategoryDTO;
import vada.dto.ProductpriceDTO;

public interface BoardUpdateService extends BoardService {
	
	public abstract int updateBoard(int productnum, BoardDTO boardDTO, ProductpriceDTO productpriceDTO, CategoryDTO categoryDTO) throws Exception; 
	
}
