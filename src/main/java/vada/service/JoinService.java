package vada.service;

import vada.dto.UserDTO;

public interface JoinService {
	
	public abstract int join(UserDTO userDTO) throws Exception;

	public abstract boolean checkUserid(String userid) throws Exception;

	public abstract boolean checkNickname(String nickname) throws Exception;
}
