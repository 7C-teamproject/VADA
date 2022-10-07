package vada.dao.impl;

import java.net.Inet4Address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.mysql.cj.protocol.Resultset;

import vada.constants.VADAConstants;
import vada.dao.ChatDAO;
import vada.dto.ChatmsgDTO;
import vada.dto.ImgDTO;
import vada.dto.KtuserchatroomDTO;
import vada.service.ChatService;

public class ChatDAOImpl extends BoardDAOImpl implements ChatDAO {

	@Override
	public int chatBoard1(int productnum, 	KtuserchatroomDTO ktuserchatroomDTO) throws Exception {

		ChatmsgDTO chatDAO = new ChatmsgDTO();
//	
// 	Timestamp timestamp=new Timestamp(System.currentTimeMillis());
//	String nickName = request.getParameter("nickName");
//	String msg = request.getParameter("msg");
//	String message = Inet4Address.getLocalHost().getHostAddress()+timestamp+"["+nickName+"] "+msg;
//	
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		int rs = 0;
		conn = getConnection();
		String sql1 = VADAConstants.props.getProperty("INSERT_KTCHATROOM_SQL");
		// insert into ktuserchatroom values('testid2', 20, 'testid',
		// 'chatroomtitletest', 2, now());
		pstmt1 = conn.prepareStatement(sql1);

		pstmt1.setString(1, ktuserchatroomDTO.getKtuserid());
		pstmt1.setInt(2,productnum);
		pstmt1.setString(3, ktuserchatroomDTO.getKtsellerid());
		pstmt1.setString(4, ktuserchatroomDTO.getChatroomtitle());
		pstmt1.setInt(5, ktuserchatroomDTO.getChatroomusercnt());
		pstmt1.setTimestamp(6, ktuserchatroomDTO.getChatroomdate());

		rs = pstmt1.executeUpdate();



		return 0;
	}

	public KtuserchatroomDTO ktchatroom(int ktproductnum) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		KtuserchatroomDTO ktuserchatroomDTO = null;
		conn = getConnection();
		String sql = VADAConstants.props.getProperty("SELECT_KTCHATROOM_SQL");

		pstmt = conn.prepareStatement(sql);

		// select * from ktuserchatroom where ktproductnum =?;
		pstmt.setInt(1, ktproductnum);

		rs = pstmt.executeQuery();

		if (rs != null && rs.next()) {
			ktuserchatroomDTO = new KtuserchatroomDTO();
			ktuserchatroomDTO.setKtuserid(rs.getString("ktuserid"));
			ktuserchatroomDTO.setKtproductnum(rs.getInt("ktproductnum"));
			ktuserchatroomDTO.setKtsellerid(rs.getString("ktsellerid"));
			ktuserchatroomDTO.setChatroomtitle(rs.getString("chatroomtitle"));
			ktuserchatroomDTO.setChatroomusercnt(rs.getInt("chatroomusercnt"));
			ktuserchatroomDTO.setChatroomdate(rs.getTimestamp("chatroomdate"));
		}

		closeConnection(rs, pstmt, conn);

		return ktuserchatroomDTO;

	}
}
