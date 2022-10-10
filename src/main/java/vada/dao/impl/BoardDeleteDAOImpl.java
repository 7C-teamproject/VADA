package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import vada.constants.VADAConstants;
import vada.dao.BoardDeleteDAO;

public class BoardDeleteDAOImpl extends BoardDAOImpl implements BoardDeleteDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;

	@Override
	public int deleteBoard(int productnum) throws Exception {		// 제품번호에 해당하는 게시글 삭제

		conn = getConnection();

		// delete from board where productnum=?
		pstmt = conn.prepareStatement(VADAConstants.props.getProperty("DELETE_BOARD_SQL"));

		pstmt.setInt(1, productnum);

		int result = pstmt.executeUpdate();

		closeConnection(pstmt, conn);

		return result;

	} // deleteBoard

	@Override
	public int deleteNotify(int notifyid) throws Exception {		// 신고글ID에 해당하는 게시글 삭제

		conn = getConnection();

		// delete from notifylist where notifyid=?
		pstmt = conn.prepareStatement(VADAConstants.props.getProperty("DELETE_NOTIFYLIST_SQL"));

		pstmt.setInt(1, notifyid);

		int result = pstmt.executeUpdate();

		closeConnection(pstmt, conn);

		return result;

	} // deleteNotify

} // class