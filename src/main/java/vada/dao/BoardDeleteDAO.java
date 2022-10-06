package vada.dao;

import vada.service.BoardDeleteService;

public interface BoardDeleteDAO extends BoardDeleteService {
	
	public abstract int deleteBoard(int productnum) throws Exception;

	public int deleteNotify(int notifyid) throws Exception;
}
