package vada.dao;

import java.sql.SQLException;

import vada.dto.UserDTO;
import vada.service.UserInfoUpdateservice;

public interface UserInfoUpdateDAO extends UserInfoUpdateservice {
	
	
	public UserDTO UserInfoSelect(String userid) throws Exception ;

	public UserDTO UserInfoUpdate(String userid, UserDTO userDTO) throws SQLException;

}
