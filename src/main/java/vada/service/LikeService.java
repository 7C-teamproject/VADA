package vada.service;

import java.util.List;
import java.util.Map;

public interface LikeService extends BoardService {

	public abstract int likeAdd(String userid, int productnum) throws Exception; 

	public abstract List<Map> likeList(String userid) throws Exception;  

	public abstract int likeDelete(String userid, int productnum) throws Exception;  
	
	public abstract List likeCheck(String userid) throws Exception;
	
	public abstract List<Integer> get_Productnum(String userid) throws Exception;

}
