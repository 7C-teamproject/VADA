package vada.dao;

import vada.dto.BoardDTO;
import vada.dto.CategoryDTO;
import vada.dto.ProductpriceDTO;
import vada.service.BoardUpdateService;

public interface BoardUpdateDAO extends BoardUpdateService {

	public abstract int updateBoard(int productnum, BoardDTO boardDTO, ProductpriceDTO productpriceDTO, CategoryDTO categoryDTO) throws Exception; 
	
}
