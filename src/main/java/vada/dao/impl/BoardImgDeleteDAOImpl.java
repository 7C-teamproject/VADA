package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import vada.constants.VADAConstants;

public class BoardImgDeleteDAOImpl extends AbstractBoardImgDAO {
	
	@Override
	public int deleteBoardImg(int imgproductnum) throws Exception {
		Connection conn =getConnection();
		String sql = VADAConstants.props.getProperty("FILE_DELETE_SQL");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, imgproductnum);
		int result = pstmt.executeUpdate();
		closeConnection(pstmt, conn);
		return result;
	} // deleteBoardFile(int)

} // class
