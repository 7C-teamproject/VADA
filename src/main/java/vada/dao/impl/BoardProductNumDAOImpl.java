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
		
		StringBuffer whereSQLBuffer = new StringBuffer();
		whereSQLBuffer.append(" order by productnum desc limit 1 ");
		String limitQuery = whereSQLBuffer.toString();
		
		// select * from board order by productnum desc limit 1 
		PreparedStatement pstmt = conn.prepareStatement(VADAConstants.props.getProperty("SELECT_BOARD_SQL") + limitQuery);
	
		ResultSet rs = pstmt.executeQuery();
		
		int productnum = 0;
		
		if (rs.next()) {
			productnum = rs.getInt("productnum");
		}

		closeConnection(rs, pstmt, conn);

		return productnum;

	} // getProductNum

} // class
