package vada.service;

public interface BoardDeleteService extends BoardService {

	public abstract int deleteBoard(int productnum) throws Exception;
	
	public int deleteNotify(int notifyid) throws Exception;
	
}
