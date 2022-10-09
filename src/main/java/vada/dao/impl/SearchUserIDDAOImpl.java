package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vada.constants.VADAConstants;
import vada.dao.SearchUserIDDAO;
import vada.dto.UserDTO;

public class SearchUserIDDAOImpl extends BoardDAOImpl implements SearchUserIDDAO{
	
	@Override
	public String searchUserID(String name, String email) throws Exception {
		
		Connection conn = getConnection();

		//select * from user where name=? and email=?
	      String sql = VADAConstants.props.getProperty("SELECT_SEARCH_USERID_SQL");

	      PreparedStatement pstmt = null;
	      ResultSet rs = null;

	      pstmt = conn.prepareStatement(sql);
	      
	      pstmt.setString(1, name);
	      pstmt.setString(2, email);
	      
	    
	      rs = pstmt.executeQuery();
	      String dbuserid = null;
	      
	      if (rs.next()) {
	        
	         dbuserid = rs.getString("userid");
	      }

	      closeConnection(rs, pstmt, conn);
	      return dbuserid;
		
	}
}
