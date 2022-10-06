package vada.dao;

import java.util.List;
import java.util.Map;

import vada.dto.BoardDTO;
import vada.dto.UserDTO;
import vada.service.ManagerService;

public interface ManagerDAO extends ManagerService {
	
	public abstract List<UserDTO> listBoard() throws Exception;
	
	public int blackList(String userid, String blackyn) throws Exception;

}
