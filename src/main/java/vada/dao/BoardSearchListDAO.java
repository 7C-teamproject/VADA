package vada.dao;

import java.util.List;
import java.util.Map;

import vada.service.BoardSearchListService;

public interface BoardSearchListDAO extends BoardSearchListService{
   
//   public abstract List<BoardDTO> listBoard(String searchCate, String searchTextParam) throws Exception;
   
//   public abstract int countAttachFiles(int bid) throws Exception;
   
   public List<Map> searchBoard(String level1Category, String level2Category, String searchText)throws Exception;
   
//   public abstract int countBoard(Map<String, String> searchCriteria) throws Exception;

}