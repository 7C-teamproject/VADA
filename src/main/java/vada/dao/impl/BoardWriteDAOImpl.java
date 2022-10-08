package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vada.constants.VADAConstants;
import vada.dao.BoardWriteDAO;
import vada.dto.BoardDTO;
import vada.dto.ImgDTO;
import vada.dto.NotifylistDTO;
import vada.util.ConnectionManager;

public class BoardWriteDAOImpl extends BoardDAOImpl implements BoardWriteDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;

	@Override
	public int writeBoard(BoardDTO boardDTO) throws Exception {

		conn = getConnection();

		pstmt = conn.prepareStatement(VADAConstants.props.getProperty("INSERT_BOARD_SQL"));

		pstmt.setString(1, boardDTO.getSellerid());
		pstmt.setString(2, boardDTO.getTitle());
		pstmt.setString(3, boardDTO.getContent());
		pstmt.setInt(4, boardDTO.getBcategorynum());

		int result = pstmt.executeUpdate();

		closeConnection(pstmt, conn);

		return result;

	} // writeBoard

	@Override
	public int writePrice(int productnum, int productprice) throws Exception {
		
		conn = getConnection();

		// insert into productprice (productpricenum, productprice, productpriceupdatedate) values (?, ?, now()) 
		pstmt = conn.prepareStatement(VADAConstants.props.getProperty("INSERT_PRODUCTPRICE_SQL"));
		
		pstmt.setInt(1, productnum);
		pstmt.setInt(2, productprice);

		int result = pstmt.executeUpdate();

		closeConnection(pstmt, getConnection());

		return result;
		
	} // writeBoard

	@Override
	public int notifyWriteBoard(NotifylistDTO notifyDTO, int notifyProductNum, String userid) throws Exception {

		Connection conn = getConnection();

//		if (conn != null) {
//			try {
//				conn.setAutoCommit(false);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}

		int result = 0;
		
		pstmt = conn.prepareStatement(VADAConstants.props.getProperty("NOTIFY_WRITE_SQL"));

		pstmt.setInt(1, notifyProductNum);
		pstmt.setString(2, notifyDTO.getNotifyreason());
		pstmt.setString(3, userid);

		result = pstmt.executeUpdate();

		closeConnection(pstmt, conn);

		return result;

	} // notifyWriteBoard

	@Override
	public int get_Notifyid() throws Exception {

		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;

		pstmt = conn.prepareStatement(VADAConstants.props.getProperty("NOTIFY_ID_SQL"));

		ResultSet rs = pstmt.executeQuery();

		int notifyid = 0;

		if (rs != null && rs.next()) {
			notifyid = rs.getInt("notifyid");
		}

		closeConnection(rs, pstmt, conn);

		return notifyid;

	} // get_Notifyid

} // class