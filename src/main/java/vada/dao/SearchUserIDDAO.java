package vada.dao;

import vada.service.SearchUserIDService;

public interface SearchUserIDDAO extends SearchUserIDService {
	String searchUserID(String name, String email) throws Exception;
}
