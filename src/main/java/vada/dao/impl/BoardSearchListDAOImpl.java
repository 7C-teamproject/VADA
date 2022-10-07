package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vada.constants.VADAConstants;
import vada.dao.BoardSearchListDAO;
import vada.dto.BoardDTO;

public class BoardSearchListDAOImpl extends BoardDAOImpl implements BoardSearchListDAO {

   @Override
   public List<Map> listBoard(String cate1, String cate2, String searchText) throws Exception {
      

      String prependSQL = VADAConstants.props.getProperty("SEARCH_VADA_LIST_SQL"); //select * from board 
      
      StringBuffer whereSQLBuffer = new StringBuffer();
      
      if(cate1.equals("1000")) { // 전체 검색(카테고리1을 선택 안 했을 때)
         whereSQLBuffer.append(" and 1=1 ");
      }
      
      else if(cate2.equals("1000")) { // 100, 200, 300.....category(대분류) // 카테고리 1은 선택하고 카테고리2를 선택 안 했을 때
         whereSQLBuffer.append(" and bcategorynum like '");
         String cate1prepend = cate1.substring(0, 2);
         whereSQLBuffer.append(cate1prepend);
         whereSQLBuffer.append("%' ");
      }
      
      else { // 100, 101, 102, 200, 201 .....(소분류) // 카테고리1 카테고리2를 모두 선택했을 때
         whereSQLBuffer.append(" and bcategorynum like '");
         whereSQLBuffer.append(cate2);
         whereSQLBuffer.append("%' ");
      }
      
      if (searchText != null) { // 검색어가 있으면 아래
         whereSQLBuffer.append(" and title like '%");
         whereSQLBuffer.append(searchText);
         whereSQLBuffer.append("%' ");
      }
      
      String searchQuery = whereSQLBuffer.toString();
            
      Connection conn = getConnection();
      PreparedStatement pstmt = conn.prepareStatement(prependSQL + searchQuery);
      
      ResultSet rs = pstmt.executeQuery();
      
      List<Map> list = new ArrayList<Map>();
      
      while (rs.next()) {
         
         BoardDTO boardDTO = new BoardDTO();
         
         Map<String, Object> map = new HashMap<String, Object>();
         
         map.put("title", rs.getString("title"));
         map.put("productnum", rs.getInt("productnum"));
         map.put("wdate", rs.getTimestamp("wdate"));
         map.put("imgsname", rs.getString("imgsname"));
         
         list.add(map);
         
      }
      
      closeConnection(rs, pstmt, conn);
      
      return list;

    }
}
