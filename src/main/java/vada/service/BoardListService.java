package vada.service;

import java.util.List;
import java.util.Map;

import vada.dto.BoardDTO;
import vada.dto.NotifylistDTO;

public interface BoardListService extends BoardService {

	public abstract List<Map> listBoard(String searchCate, String searchTextParam) throws Exception;
	
	public List<NotifylistDTO> notifyListBoard() throws Exception;
	
	public abstract int countAttachFiles(int bid) throws Exception;
	

}
