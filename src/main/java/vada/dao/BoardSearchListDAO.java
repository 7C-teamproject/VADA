package vada.dao;

import java.util.List;
import java.util.Map;

import vada.service.BoardSearchListService;

public interface BoardSearchListDAO extends BoardSearchListService{
   
   public abstract List<Map> searchBoard(String level1Category, String level2Category, String searchText)throws Exception;
   
}