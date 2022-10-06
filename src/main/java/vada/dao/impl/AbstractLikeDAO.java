package vada.dao.impl;

import java.util.List;
import java.util.Map;

import vada.service.LikeService;

public class AbstractLikeDAO extends BoardDAOImpl implements LikeService{

	@Override
	public int likeAdd(String userid, int productnum) throws Exception {
		return 0;
	}

	@Override
	public List<Map> likeList(String userid) throws Exception {
		return null ;
	}

	@Override
	public int likeDelete(String userid, int productnum) throws Exception {
		return 0;
	}
	
	@Override
	public List likeCheck(String userid) throws Exception{
		return null;
	}

	@Override
	public List<Integer> get_Productnum(String userid) throws Exception {
		return null;
	}

}
