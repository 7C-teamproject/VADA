package vada.dao.board.func;

import java.util.List;

import vada.dto.BoardDTO;
import vada.service.board.func.BuyListSerive;

public interface BuyListDAO extends BuyListSerive {
	
	public abstract List<BoardDTO> buyList(String userid) throws Exception; 
	public List<BoardDTO> sellList(String userid) throws Exception;

}
