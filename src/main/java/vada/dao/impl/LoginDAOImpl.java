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
   public List<UserDTO> userLogin(String userid, String userpw) throws Exception {
      Connection conn = getConnection();

      //SELECT_USER_LOGIN_SQL= select * from user where userid=? and userpw=? and adminyn=? 
      //SELECT_USER_LOGIN_SQL= select * from user where adminyn='no' 
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
   public List<UserDTO> adminynLogin(String userid, String userpw) throws Exception {
     Connection conn = getConnection();

     //select * from user where adminyn='yes'
      String sql = VADAConstants.props.getProperty("SELECT_ADMIN_LOGIN_SQL");

      PreparedStatement pstmt = null;
      ResultSet rs = null;
      System.out.println("testsetsetsetsetsetsetset");
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