package vada.service.board.func;

import java.util.List;

import vada.dto.BoardDTO;
import vada.service.board.BoardService;

public interface BuyListSerive extends BoardService {

	public abstract List<BoardDTO> buyList(String userid) throws Exception; 
	public List<BoardDTO> sellList(String userid) throws Exception;
	
}
