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
	public List<Map> searchBoard(String level1Category, String level2Category, String searchText) throws Exception {

		StringBuffer whereSQLBuffer = new StringBuffer();

		// 전체 검색(카테고리1을 선택 안 했을 때)
		if (level1Category.equals("1000")) { 
			whereSQLBuffer.append(" and 1=1 ");
		}

		// 카테고리 1은 선택하고 카테고리2를 선택 안 했을 때
		else if (level2Category.equals("1000")) {
			whereSQLBuffer.append(" and bcategorynum like '");
			String cate1prepend = level1Category.substring(0, 2);
			whereSQLBuffer.append(cate1prepend);
			whereSQLBuffer.append("%' ");
		}

		// 카테고리1 카테고리2를 모두 선택했을 때
		else { 
			whereSQLBuffer.append(" and bcategorynum like '");
			whereSQLBuffer.append(level2Category);
			whereSQLBuffer.append("%' ");
		}

		// 검색어가 있을 때 게시글 제목에 해당 검색어가 포함된 게시글 가져옴
		if (searchText != null) { 
			whereSQLBuffer.append(" and title like '%");
			whereSQLBuffer.append(searchText);
			whereSQLBuffer.append("%' ");
		}
		
		whereSQLBuffer.append(" order by wdate desc ");

		String searchQuery = whereSQLBuffer.toString();

		Connection conn = getConnection();
		
		// select * from board
		PreparedStatement pstmt = conn.prepareStatement(VADAConstants.props.getProperty("SELECT_BOARD_IMG_PRICE_SQL") + searchQuery);

		ResultSet rs = pstmt.executeQuery();

		List<Map> boardList = new ArrayList<Map>();

		while (rs.next()) {

			BoardDTO boardDTO = new BoardDTO();

			Map<String, Object> boardMap = new HashMap<String, Object>();

			boardMap.put("title", rs.getString("title"));
			boardMap.put("productnum", rs.getInt("productnum"));
			boardMap.put("wdate", rs.getTimestamp("wdate"));
			boardMap.put("imgsname", rs.getString("imgsname"));
			boardMap.put("productprice", rs.getInt("productprice"));

			boardList.add(boardMap);

		}

		closeConnection(rs, pstmt, conn);

		return boardList;

	} // searchBoard
	
} // class
