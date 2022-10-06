package vada.service;

public interface SearchUserPWService extends SearchUserService{
	
	String searchUserPW(String userid, String email)throws Exception;
}
