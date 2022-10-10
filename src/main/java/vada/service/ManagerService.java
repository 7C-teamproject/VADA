package vada.service;

import java.util.List;
import java.util.Map;

import vada.dto.BoardDTO;
import vada.dto.UserDTO;

public interface ManagerService extends BoardService {

	public abstract List<UserDTO> listBoard() throws Exception;

	public abstract int blackList(String userid, String blackyn) throws Exception;
}
