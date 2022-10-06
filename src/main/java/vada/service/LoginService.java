package vada.service;

import java.util.List;

import vada.dto.UserDTO;

public interface LoginService {
   
   public List<UserDTO> userLogin(String userid, String userpw) throws Exception;
   List<UserDTO> adminynLogin(String userid, String userpw) throws Exception;
}