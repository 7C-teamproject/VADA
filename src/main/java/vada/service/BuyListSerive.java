package vada.service;

import java.util.List;
import java.util.Map;

import vada.dto.BoardDTO;

public interface BuyListSerive extends BoardService {

	public abstract List<BoardDTO> buylistadd(String userid) throws Exception; 
	
}
