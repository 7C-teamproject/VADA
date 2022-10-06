package vada.service;

import vada.dto.UserDTO;

public interface JoinService {
	
	public abstract int join(UserDTO userDTO) throws Exception;
	
	boolean checkUserid(String userid) throws Exception;
	
	boolean checkNickname(String nickname) throws Exception;
}
