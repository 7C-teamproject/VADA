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
	// 구매목록 리스트를 얻기 위한 메소드	
	public List<BoardDTO> buyList(String userid) throws Exception {
		
		Connection conn = getConnection();

		// select * from board where buyerid=?
		PreparedStatement pstmt = conn.prepareStatement(VADAConstants.props.getProperty("SELECT_BUY_LIST_SQL"));

		pstmt.setString(1, userid);

		ResultSet rs = pstmt.executeQuery();

		BoardDTO boardDTO = null;
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		
		while (rs.next()) {
			
			boardDTO = new BoardDTO();

			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setSoldoutdate(rs.getTimestamp("soldoutdate"));
			boardDTO.setProductnum(rs.getInt("productnum"));
			boardDTO.setReview(rs.getString("review"));

			boardList.add(boardDTO);
			
		}

		return boardList;
	
	} // buyList

} // class