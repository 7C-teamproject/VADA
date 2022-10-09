package vada.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vada.constants.VADAConstants;

public class LikeCheckDAOImpl extends AbstractLikeDAO {

   
   @Override
   public List likeCheck(String userid) throws Exception {

	   //select * from likelist where likeuserid=?
      PreparedStatement pstmt = getConnection().prepareStatement(VADAConstants.props.getProperty("SELECT_LIKE_CHECK_SQL"));
      
      pstmt.setString(1, userid);
      ResultSet rs = pstmt.executeQuery(); // executeQuery() : select~~~,  executeUpdate() : insert~~, update~~
      List list = new ArrayList();
      while (rs.next()){
         list.add(rs.getInt("likeproductnum"));
      }
   
      closeConnection(rs, pstmt);
      
      return list;
   }
   
}