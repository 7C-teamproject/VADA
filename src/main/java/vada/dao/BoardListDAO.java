package vada.dao;

import java.util.List;
import java.util.Map;

import vada.dto.BoardDTO;
import vada.dto.NotifylistDTO;
import vada.service.BoardListService;

public interface BoardListDAO extends BoardListService {
	
	public abstract List<Map> getBoardList() throws Exception;	
	
	public abstract List<NotifylistDTO> notifyListBoard() throws Exception;

}
