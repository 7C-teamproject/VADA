package vada.service;

import java.util.Map;

import vada.dto.BoardDTO;
import vada.dto.NotifylistDTO;

public interface BoardDetailService extends BoardService {
   
   public abstract Map<String, Object> getBoardList(int bid) throws Exception;
   public Map<String, Object> notifyView(int notifyid) throws Exception;
   public int reserveBoard(int productnum, String command, String userid) throws Exception;

}