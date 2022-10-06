package vada.service;

import java.util.List;
import java.util.Map;


public interface BoardSearchListService extends BoardService {

//	public abstract List<BoardDTO> listBoard(String searchCate, String searchTextParam) throws Exception;

//	public abstract int countAttachFiles(int bid) throws Exception;

	 public List<Map> listBoard(String cate1, String cate2, String searchText)throws Exception;

//	public abstract int countBoard(Map<String, String> searchCriteria) throws Exception;

}
