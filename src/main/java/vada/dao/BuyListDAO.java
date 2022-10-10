package vada.dao;

import java.util.List;
import java.util.Map;

import vada.dto.BoardDTO;
import vada.dto.NotifylistDTO;
import vada.service.BoardListService;
import vada.service.BuyListSerive;

public interface BuyListDAO extends BuyListSerive {
	
	public abstract List<BoardDTO> buyList(String userid) throws Exception; 
	public List<BoardDTO> sellList(String userid) throws Exception;

}
