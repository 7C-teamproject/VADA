package vada.dao;

import java.util.List;

import vada.dto.UserDTO;
import vada.service.LoginService;

public interface LoginDAO extends LoginService{
	
	   public abstract List<UserDTO> userLogin(String userid, String userpw) throws Exception;
	   
	   public abstract List<UserDTO> adminynLogin(String userid, String userpw) throws Exception;
}
