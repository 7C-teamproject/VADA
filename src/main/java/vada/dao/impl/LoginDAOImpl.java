package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import vada.constants.VADAConstants;
import vada.dao.LoginDAO;
import vada.dto.UserDTO;

public class LoginDAOImpl extends BoardDAOImpl implements LoginDAO {

	@Override
	// 유저 아이디와 패스워드가 user테이블에 존재하는지 확인하기 위한 파라미터
	// 로그인을 하기 위한 메소드
	public List<UserDTO> userLogin(String userid, String userpw) throws Exception {		
		
		Connection conn = getConnection();

		// SELECT_USER_LOGIN_SQL= select * from user where adminyn='no'
		String sql = VADAConstants.props.getProperty("SELECT_USER_LOGIN_SQL");

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		pstmt = conn.prepareStatement(sql);

		List<UserDTO> list = new ArrayList<UserDTO>();

		rs = pstmt.executeQuery();

		UserDTO userDTO = null;
		while (rs.next()) {
			userDTO = new UserDTO();
			userDTO.setUserid(rs.getString("userid"));
			userDTO.setUserpw(rs.getString("userpw"));
			userDTO.setNickname(rs.getString("nickname"));
			userDTO.setAdminyn(rs.getString("adminyn"));
			userDTO.setBlackyn(rs.getString("blackyn"));
			userDTO.setCurrentip(rs.getString("currentip"));
			list.add(userDTO);
		}

		closeConnection(rs, pstmt, conn);
		return list;
	}

	@Override
	// 관리자 아이디와 패스워드가 user테이블에 adminyn='yes' 상태로 존재하는지 확인하기 위한 파라미터
	// 관리자 로그인을 위한 메소드
	public List<UserDTO> adminynLogin(String userid, String userpw) throws Exception {
		
		Connection conn = getConnection();

		// select * from user where adminyn='yes'
		String sql = VADAConstants.props.getProperty("SELECT_ADMIN_LOGIN_SQL");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		pstmt = conn.prepareStatement(sql);

		List<UserDTO> list = new ArrayList<UserDTO>();

		rs = pstmt.executeQuery();

		UserDTO userDTO = null;
		while (rs.next()) {
			userDTO = new UserDTO();
			userDTO.setUserid(rs.getString("userid"));
			userDTO.setUserpw(rs.getString("userpw"));
			userDTO.setNickname(rs.getString("nickname"));
			userDTO.setAdminyn(rs.getString("adminyn"));
			userDTO.setBlackyn(rs.getString("blackyn"));

			list.add(userDTO);
		}

		closeConnection(rs, pstmt, conn);
		return list;

	}
}