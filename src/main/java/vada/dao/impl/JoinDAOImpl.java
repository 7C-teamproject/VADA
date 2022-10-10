package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vada.constants.VADAConstants;
import vada.dao.JoinDAO;
import vada.dto.UserDTO;

public class JoinDAOImpl extends BoardDAOImpl implements JoinDAO {

	@Override
	// 회원가입 테이블 작성을 위한 user정보를 담은 파라미터 및 메소드
	public int join(UserDTO userDTO) throws Exception {

		Connection conn = getConnection();

		// insert into user values (?, ?, ?, ?, ?, ?, ?, now(), ?, 'no', ?, ?, ?)
		String sql = VADAConstants.props.getProperty("INSERT_JOIN_SQL");

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, userDTO.getUserid());
		pstmt.setString(2, userDTO.getUserpw());
		pstmt.setString(3, userDTO.getAddress());
		pstmt.setString(4, userDTO.getDetailaddress());
		pstmt.setString(5, userDTO.getEmail());
		pstmt.setString(6, userDTO.getTel());
		System.out.println("Impl nickname====>" + userDTO.getNickname());
		pstmt.setString(7, userDTO.getNickname());
		pstmt.setString(8, "noneip"); // 채팅 진행시 필요한 IP
		pstmt.setString(9, "no"); // 관리자인지 아닌지
		pstmt.setString(10, userDTO.getName());
		pstmt.setInt(11, userDTO.getInterestcategorynum());

		int result = pstmt.executeUpdate();

		closeConnection(pstmt, conn);

		return result;

	} // join()

	@Override
	public boolean checkUserid(String userid) throws Exception {
		// 중복아이디 회원 검사를 위한 메소드

		boolean flag = false;

		Connection conn = getConnection();

		// select userid from user
		String sql = VADAConstants.props.getProperty("SELECT_CHECK_USERID_SQL");

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			// 중복 아이디가 존재하면
			if (rs.getString("userid").equals(userid)) {
				flag = false;
				break;
			} else { // 중복 아이디가 존재하지 않으면
				flag = true;
			}
		}

		closeConnection(pstmt, conn);
		return flag;
	}

	@Override
	public boolean checkNickname(String nickname) throws Exception {
		// 중복 닉네임 검사를 위한 메소드

		boolean flag = false;

		Connection conn = getConnection();

		// select nickname from user
		String sql = VADAConstants.props.getProperty("SELECT_CHECK_NICKNAME_SQL");

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			// 중복 닉네임이 존재하면
			if (rs.getString("nickname").equals(nickname)) {
				flag = false;
				break;
			} else { // 중복 닉네임이 존재하지 않으면
				flag = true;
			}
		}
		
		closeConnection(pstmt, conn);
		return flag;
	}

} // class
