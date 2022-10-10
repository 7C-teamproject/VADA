package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import vada.constants.VADAConstants;
import vada.dao.NoteMessageDAO;
import vada.dto.NoteMessageDTO;

public class NoteMessageDAOImpl extends BoardDAOImpl implements NoteMessageDAO {

	// 보낸쪽지 및 받은 쪽지 확인을 위해 DB에 저장하기 위한 메소드
	public int insertMessage(NoteMessageDTO noteMessageDTO) {
		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			// "insert into notemessage (notefromuserid, notetouserid, noteproductnum, message, m_date) values(?, ?, ?, ?, now())"
			pstmt = conn.prepareStatement(VADAConstants.props.getProperty("INSERT_MESSAGE_SQL"));
			pstmt.setString(1, noteMessageDTO.getNotefromuserid());
			pstmt.setString(2, noteMessageDTO.getNotetouserid());
			pstmt.setInt(3, noteMessageDTO.getNoteproductnum());
			
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaa"+noteMessageDTO.getNoteproductnum());
			pstmt.setString(4, noteMessageDTO.getMessage());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(pstmt, conn);
		}

		return result;
	} // insertMessage

	// notetouserid에 매칭되는 메시지 데이터를 꺼내기 위한 파라미터이며 나에게 온 쪽지 목록을 출력하기 위한 메소드
	public ArrayList<NoteMessageDTO> showMessage() {
		
		ArrayList<NoteMessageDTO> list_message = new ArrayList<NoteMessageDTO>();

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// select * from notemessage
			pstmt = conn.prepareStatement(VADAConstants.props.getProperty("SELECT_MESSAGE_SQL"));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String notefromuserid = rs.getString("notefromuserid");
				String dbnotetouserid = rs.getString("notetouserid");
				int noteproductnum = rs.getInt("noteproductnum");
				String message = rs.getString("message");
				Timestamp m_date = rs.getTimestamp("m_date");

				NoteMessageDTO noteMessageDTO = new NoteMessageDTO(notefromuserid, dbnotetouserid, noteproductnum, message, m_date);
				list_message.add(noteMessageDTO);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(pstmt, conn);
		}

		return list_message;
	} // showMessage

} // class