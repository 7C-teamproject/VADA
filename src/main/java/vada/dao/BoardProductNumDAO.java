package vada.dao;

import vada.service.BoardProductNumService;

public interface BoardProductNumDAO extends BoardProductNumService {
	
	public abstract int getProductNum() throws Exception;	

}
