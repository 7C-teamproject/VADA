package vada.dao.impl;

import java.net.Inet4Address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import vada.constants.VADAConstants;
import vada.dao.ChatDAO;
import vada.dto.ChatmsgDTO;
import vada.dto.ImgDTO;
import vada.dto.KtuserchatroomDTO;
import vada.service.ChatService;

public class ChatDAOImpl extends BoardDAOImpl implements ChatDAO {

	@Override
	public int ktchatBoard(int productnum, KtuserchatroomDTO ktuserchatroomDTO) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt1 = null;
		int rs = 0;
		conn = getConnection();
		String sql1 = VADAConstants.props.getProperty("INSERT_KTCHATROOM_SQL");
//		insert into ktuserchatroom  (ktuserid  ,ktproductnum , ktsellerid , chatroomtitle , chatroomusercnt , chatroomdate) values( ? ,  ? ,  ? ,  ? , ? ,  ?);

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

	
	public List<KtuserchatroomDTO> ktchatroomList(int productnum) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		KtuserchatroomDTO ktuserchatroomDTO = null;
		conn = getConnection();
		String sql = VADAConstants.props.getProperty("SELECT_KTCHATROOM_SQL");

		pstmt = conn.prepareStatement(sql);

		// SELECT_KTCHATROOM_SQL=select * from ktuserchatroom where ktuserid  =?
		pstmt.setInt(1, productnum);

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
