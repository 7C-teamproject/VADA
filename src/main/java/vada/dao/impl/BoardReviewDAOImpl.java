package vada.dao.impl;

import java.sql.PreparedStatement;

import vada.constants.VADAConstants;
import vada.dao.BoardReviewDAO;
import vada.dto.BoardDTO;

public class BoardReviewDAOImpl extends BoardDAOImpl implements BoardReviewDAO{
	
	public int reviewBoard(BoardDTO boardDTO) throws Exception {
		
		
		PreparedStatement pstmt =  getConnection().prepareStatement(VADAConstants.props.getProperty("REVIEW_SQL"));

//		pstmt.setString(1, "======리뷰써라");
//		pstmt.setInt(2, 2);
//		pstmt.setInt(3, 8);
		
		
		pstmt.setString(1, boardDTO.getReview());
		pstmt.setInt(2, boardDTO.getReviewscore());
		pstmt.setInt(3, boardDTO.getProductnum());
		
		
		int result = pstmt.executeUpdate();
        pstmt.close();	
		
		return result;
		
	}
}
