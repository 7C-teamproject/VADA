package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vada.constants.VADAConstants;
import vada.dao.UserInfoUpdateDAO;
import vada.dto.BoardDTO;
import vada.dto.CategoryDTO;
import vada.dto.ProductpriceDTO;
import vada.dto.UserDTO;

public class UserInfoUpdateDAOImpl extends BoardDAOImpl implements UserInfoUpdateDAO {

	@Override
	public UserDTO UserInfoSelect(String userid) throws SQLException {

		UserDTO userDTO = new UserDTO();
		Connection conn = getConnection();
		//SELECT_USERINFO_UPDATE_SQL=select   userid, userpw, address, name, tel, email, nickname, detailaddress  
		//              										from `user` where userid =?;  
		PreparedStatement pstmt = null;
		ResultSet result =null ;

		pstmt = conn.prepareStatement(VADAConstants.props.getProperty("SELECT_USERINFO_UPDATE_SQL"));
		pstmt.setString(1,userid);
		
		result = pstmt.executeQuery();
		
		if(result.next()) {
			userDTO.setUserid(result.getString("userid"));
			userDTO.setUserpw(result.getString("userpw"));
			userDTO.setAddress(result.getString("address"));
			userDTO.setName(result.getString("name"));
			userDTO.setTel(result.getString("tel"));
			userDTO.setEmail(result.getString("email"));
			userDTO.setNickname(result.getString("nickname"));
			userDTO.setDetailaddress(result.getString("detailaddress"));
			
		}
		
		closeConnection(result, pstmt, conn);
		
		return userDTO;
	}
	
	
	
	@Override
	public UserDTO UserInfoUpdate(String userid, UserDTO userDTO) throws SQLException {
	
		Connection conn = getConnection();
		
		PreparedStatement pstmt = null;
		int result =0 ;
		
		pstmt = conn.prepareStatement(VADAConstants.props.getProperty("UPDATE_USERINFO_UADATE_SQL"));
		//UPDATE_USERINFO_UADATE_SQL=update user  set  userid=?, userpw=?, address=?, name=?, tel=?, email=?, nickname=?,
		//													detailaddress =?  where  userid =?
		
		System.out.println("UserDTO =========>" + userDTO);
		pstmt.setString(1, userDTO.getUserid());
		pstmt.setString(2, userDTO.getUserpw());
		pstmt.setString(3, userDTO.getAddress());
		pstmt.setString(4, userDTO.getName());
		pstmt.setString(5, userDTO.getTel());
		pstmt.setString(6, userDTO.getEmail());
		pstmt.setString(7, userDTO.getNickname());
		pstmt.setString(8, userDTO.getDetailaddress());
		pstmt.setString(9, userid);
		
		result = pstmt.executeUpdate();
		closeConnection(pstmt, conn);
		return userDTO;
	}
	
	
}
