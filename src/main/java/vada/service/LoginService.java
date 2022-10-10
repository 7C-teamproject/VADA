package vada.service;

import java.util.List;

import vada.dto.UserDTO;

public interface LoginService {

	public abstract List<UserDTO> userLogin(String userid, String userpw) throws Exception;

	public abstract List<UserDTO> adminynLogin(String userid, String userpw) throws Exception;
}