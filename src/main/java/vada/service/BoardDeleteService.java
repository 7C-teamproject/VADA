package vada.service;

public interface BoardDeleteService extends BoardService {

	public abstract int deleteBoard(int productnum) throws Exception;

	public abstract int deleteNotify(int notifyid) throws Exception;
	
}
