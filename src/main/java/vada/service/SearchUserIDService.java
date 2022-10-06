package vada.service;

public interface SearchUserIDService extends SearchUserService{
	
	String searchUserID(String name, String email) throws Exception;
	
}
