package vada.dao.impl;

import java.sql.PreparedStatement;

import vada.constants.VADAConstants;
import vada.dao.LikeAddDAO;

public class LikeListDeleteDAOImpl extends AbstractLikeDAO implements LikeAddDAO {

	@Override
	public int likeDelete(String userid, int productnum) throws Exception {
		
		//delete from likelist where likeproductnum=? and likeuserid=?
		PreparedStatement pstmt = getConnection().prepareStatement(VADAConstants.props.getProperty("DELETE_LIKE_DELETE_SQL"));
		pstmt.setInt(1, productnum);
		pstmt.setString(2, userid);
		int result = pstmt.executeUpdate();
		closeConnection(pstmt, getConnection());
		return 0;
	}
}
