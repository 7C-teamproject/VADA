package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vada.constants.VADAConstants;
import vada.dao.JoinDAO;
import vada.dto.UserDTO;

public class JoinDAOImpl extends BoardDAOImpl implements JoinDAO {
	
	@Override
	public int join(UserDTO userDTO) throws Exception {
	
		Connection conn = getConnection();
		
		String sql = VADAConstants.props.getProperty("JOIN_SQL");
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, userDTO.getUserid());
		pstmt.setString(2, userDTO.getUserpw());
		pstmt.setString(3, userDTO.getAddress());
		pstmt.setString(4, userDTO.getDetailaddress());
		pstmt.setString(5, userDTO.getEmail());
		pstmt.setString(6, userDTO.getTel());
		pstmt.setString(7, userDTO.getNickname());
		pstmt.setString(8, "noneip");
		pstmt.setString(9, "no");
		pstmt.setString(10, userDTO.getName());
		pstmt.setInt(11, userDTO.getInterestcategorynum());
		
		int result = pstmt.executeUpdate();
		
		closeConnection(pstmt, conn);
		
		return result;
		
	} // join()
	
	@Override
	public boolean checkUserid(String userid) throws Exception {
		
		boolean flag = false;
		
		Connection conn = getConnection();
		
		String sql = VADAConstants.props.getProperty("CHECK_USERID_SQL");
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			if(rs.getString("userid").equals(userid)) {
				System.out.println("중복 아이디 존재함 - 회원가입 실패");
				flag = false;
				break;
			}
			else {
				System.out.println("중복 아이디 없음 - 회원가입 성공");
				flag = true;
			}
		}
		System.out.println("flag=======>" + flag);
		closeConnection(pstmt, conn);
		return flag;
	}
	
	@Override
	public boolean checkNickname(String nickname) throws Exception {
		boolean flag = false;
		
		Connection conn = getConnection();
		
		String sql = VADAConstants.props.getProperty("CHECK_NICKNAME_SQL");
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			if(rs.getString("nickname").equals(nickname)) {
				System.out.println("중복 닉네임 존재함 - 회원가입 실패");
				flag = false;
				break;
			}
			else {
				System.out.println("중복 닉네임 없음 - 회원가입 성공");
				flag = true;
			}
		}
		System.out.println("flag=======>" + flag);
		closeConnection(pstmt, conn);
		return flag;
	}
	
} // class
