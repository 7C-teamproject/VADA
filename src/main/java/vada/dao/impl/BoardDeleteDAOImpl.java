package vada.dao.impl;

import java.sql.PreparedStatement;

import vada.constants.VADAConstants;
import vada.dao.BoardDeleteDAO;

public class BoardDeleteDAOImpl extends BoardDAOImpl implements BoardDeleteDAO {

	@Override
	public int deleteBoard(int productnum) throws Exception {
		PreparedStatement pstmt 
			= getConnection().prepareStatement(VADAConstants.props.getProperty("DELETE_SQL"));
		pstmt.setInt(1, productnum);
		int result = pstmt.executeUpdate();
		closeConnection(pstmt, getConnection());
		return result;
	} // deleteBoard
	
	@Override
	public int deleteNotify(int notifyid) throws Exception {
		PreparedStatement pstmt 
		= getConnection().prepareStatement(VADAConstants.props.getProperty("NOTIFY_DELETE_SQL"));
		pstmt.setInt(1, notifyid);
		int result = pstmt.executeUpdate();
		closeConnection(pstmt, getConnection());
		return result;
	}
	
} // class