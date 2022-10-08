package vada.dao;

import java.util.Map;

import vada.dto.BoardDTO;
import vada.dto.NotifylistDTO;
import vada.service.BoardViewService;

public interface BoardViewDAO extends BoardViewService {
   
   public abstract Map<String, Object> viewBoard(int bid) throws Exception;
   public Map<String, Object> notifyView(int notifyid) throws Exception ;
   public int reserveBoard(int productnum, String command, String userid) throws Exception;

}