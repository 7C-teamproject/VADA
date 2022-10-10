package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vada.constants.VADAConstants;
import vada.dao.SearchUserPWDAO;

public class SearchUserPWDAOImpl extends BoardDAOImpl implements SearchUserPWDAO {

	@Override
	// 비밀번호 찾기 위한 메소드로써 아이디와 이메일로 찾기 위한 파리미터
	public String searchUserPW(String userid, String email) throws Exception {

		Connection conn = getConnection();

		// select * from user where userid=? and email=?
		String sql = VADAConstants.props.getProperty("SELECT_SEARCH_USERPW_SQL");

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, userid);
		pstmt.setString(2, email);

		rs = pstmt.executeQuery();
		String dbuserpw = null;

		if (rs.next()) {

			dbuserpw = rs.getString("userpw");
		}

		closeConnection(rs, pstmt, conn);
		return dbuserpw;

	} // searchUserPW
} // class
