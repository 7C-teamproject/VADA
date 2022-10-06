package vada.dao;

import vada.dto.UserDTO;
import vada.service.JoinService;

public interface JoinDAO extends JoinService {
	public abstract int join(UserDTO userDTO) throws Exception;
	
	boolean checkUserid(String userid) throws Exception;
	
	boolean checkNickname(String nickname) throws Exception;
}
