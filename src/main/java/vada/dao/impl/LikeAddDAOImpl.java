package vada.dao.impl;

import java.sql.PreparedStatement;

import vada.constants.VADAConstants;
import vada.dao.LikeAddDAO;

public class LikeAddDAOImpl extends AbstractLikeDAO implements LikeAddDAO {

	@Override
	public int likeAdd(String userid, int productnum) throws Exception {
	
		//insert into likelist (likeuserid, likeproductnum, likedate) values (?, ?, now())
		PreparedStatement pstmt = getConnection().prepareStatement(VADAConstants.props.getProperty("INSERT_LIKE_ADD_SQL"));
		
		pstmt.setString(1, userid);
		pstmt.setInt(2, productnum);
		pstmt.executeUpdate();
		
		closeConnection(pstmt, getConnection());
		
		return 0;
	}
}
