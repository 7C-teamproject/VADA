package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vada.constants.VADAConstants;
import vada.dao.ChatDAO;
import vada.dto.KtuserchatroomDTO;

public class ChatDAOImpl extends BoardDAOImpl implements ChatDAO {

	@Override
	public int ktchatBoard(int productnum, KtuserchatroomDTO ktuserchatroomDTO) throws Exception {
	
		
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		int rs = 0;
		conn = getConnection();
		
		//insert into ktuserchatroom values(?, ?, ?, ?, ?, ?)
		String sql1 = VADAConstants.props.getProperty("INSERT_KTCHATROOM_SQL");

		pstmt1 = conn.prepareStatement(sql1);

		pstmt1.setString(1, ktuserchatroomDTO.getKtuserid());
		pstmt1.setInt(2, productnum);
		pstmt1.setString(3, ktuserchatroomDTO.getKtsellerid());
		pstmt1.setString(4, ktuserchatroomDTO.getChatroomtitle());
		pstmt1.setInt(5, ktuserchatroomDTO.getChatroomusercnt());
		pstmt1.setTimestamp(6, ktuserchatroomDTO.getChatroomdate());

		rs = pstmt1.executeUpdate();

		return 0;
	}

	
	public List<KtuserchatroomDTO> ktchatroomList(String ktuserid) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		KtuserchatroomDTO ktuserchatroomDTO = null;
		conn = getConnection();
		
		//select * from ktuserchatroom where ktuserid=?
		String sql = VADAConstants.props.getProperty("SELECT_KTCHATROOM_SQL");

		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, ktuserid);

		rs = pstmt.executeQuery();
		List<KtuserchatroomDTO> list = null;
		if (rs != null && rs.next()) {
			list = new ArrayList<KtuserchatroomDTO>();
			while (rs.next()) {
				ktuserchatroomDTO = new KtuserchatroomDTO();
				ktuserchatroomDTO.setKtuserid(rs.getString("ktuserid"));
				ktuserchatroomDTO.setKtproductnum(rs.getInt("ktproductnum"));
				ktuserchatroomDTO.setKtsellerid(rs.getString("ktsellerid"));
				ktuserchatroomDTO.setChatroomtitle(rs.getString("chatroomtitle"));
				ktuserchatroomDTO.setChatroomusercnt(rs.getInt("chatroomusercnt"));
				ktuserchatroomDTO.setChatroomdate(rs.getTimestamp("chatroomdate"));
				list.add(ktuserchatroomDTO);
			}
		}
		closeConnection(rs, pstmt, conn);

		return list;

	}
}
