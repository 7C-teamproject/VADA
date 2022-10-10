package vada.dao;

import vada.service.SearchUserPWService;

public interface SearchUserPWDAO extends SearchUserPWService {

	public abstract String searchUserPW(String userid, String email)throws Exception;
}
