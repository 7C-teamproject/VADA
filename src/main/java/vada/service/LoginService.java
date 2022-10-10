package vada.service;

import java.util.List;

import vada.dto.UserDTO;

public interface LoginService {

	public abstract UserDTO userLogin(String userid, String userpw) throws Exception;

	public abstract UserDTO adminynLogin(String userid, String userpw) throws Exception;
}