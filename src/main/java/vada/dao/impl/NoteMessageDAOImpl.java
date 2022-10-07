package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import vada.dto.NoteMessageDTO;

public class NoteMessageDAOImpl extends BoardDAOImpl {

   public int insertMessage(NoteMessageDTO noteMessageDTO) {

      Connection conn = getConnection();
      PreparedStatement pstmt = null;
      int result = 0;
      try {

         String sql = "insert into note_message (notefromuserid, notetouserid, message, m_date) values(?, ?, ?, now())";

         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, noteMessageDTO.getNotefromuserid());
         pstmt.setString(2, noteMessageDTO.getNotetouserid());
         pstmt.setString(3, noteMessageDTO.getMessage());

         result = pstmt.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         closeConnection(pstmt, conn);
      }

      return result;
   }
   
	   public ArrayList<NoteMessageDTO> showboard(String notetouserid) { //TODO 효주님 이거 뭥믜?
      ArrayList<NoteMessageDTO> list_message = new ArrayList<NoteMessageDTO>();
      
      Connection conn = getConnection();
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      try {

         String sql = " select * from note_message";
//         NoteMessageDTO dto = new NoteMessageDTO();

         pstmt = conn.prepareStatement(sql);
//         pstmt.setString(1, email);
         rs = pstmt.executeQuery();
         
         while (rs.next()) {
            
//            int num = rs.getInt("num");
            String notefromuserid = rs.getString("notefromuserid");
            String dbnotetouserid = rs.getString("notetouserid");
            String message = rs.getString("message");
            Timestamp m_date = rs.getTimestamp("m_date");
            
            NoteMessageDTO noteMessageDTO = new NoteMessageDTO(notefromuserid, dbnotetouserid, message, m_date);
            list_message.add(noteMessageDTO);
            
         }
         
         System.out.println("list_message ===============>" + list_message);

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         closeConnection(pstmt, conn);
      }
      
      return list_message;
      
   }

}