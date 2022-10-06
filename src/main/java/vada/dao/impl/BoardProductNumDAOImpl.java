package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vada.constants.VADAConstants;
import vada.dao.BoardProductNumDAO;

public class BoardProductNumDAOImpl extends BoardDAOImpl implements BoardProductNumDAO {

	@Override
	public int getProductNum() throws Exception {
		
		Connection conn = getConnection();
		String sql = VADAConstants.props.getProperty("PRODUCT_NUM_SQL");
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		int result = 0;
		if(rs.next()) {
			result = rs.getInt("productnum");
		}
		closeConnection(rs, pstmt, conn);
		return result;
	} // getBID()

} // class
