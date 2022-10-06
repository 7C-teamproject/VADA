package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vada.constants.VADAConstants;
import vada.dao.BoardDeleteDAO;
import vada.dao.BuyListDAO;
import vada.dto.BoardDTO;

public class BuyListDAOImpl extends BoardDAOImpl implements BuyListDAO {

	@Override
	public List<BoardDTO> buylistadd(String userid) throws Exception {

		Connection conn = getConnection();

		String sql = VADAConstants.props.getProperty("BUY_LIST_SQL");

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1,userid);
		ResultSet rs = pstmt.executeQuery();
		
		BoardDTO boardDTO = null;
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		while(rs.next()) {
			boardDTO = new BoardDTO();
			
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setSoldoutdate(rs.getTimestamp("soldoutdate"));
			boardDTO.setProductnum(rs.getInt("productnum"));
			
			list.add(boardDTO);
		}
		
		return list;
	}

} // class