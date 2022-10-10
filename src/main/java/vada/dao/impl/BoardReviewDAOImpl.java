package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vada.constants.VADAConstants;
import vada.dao.BoardReviewDAO;
import vada.dto.BoardDTO;

public class BoardReviewDAOImpl extends BoardDAOImpl implements BoardReviewDAO {

	// 리뷰를 수정하기 위한 메소드
	public int updateBoardReview(BoardDTO boardDTO) throws Exception {

		Connection conn = getConnection();

		// update board set review=?, reviewscore=? where productnum=?
		PreparedStatement pstmt = conn.prepareStatement(VADAConstants.props.getProperty("UPDATE_BOARD_REVIEW_SQL"));

		pstmt.setString(1, boardDTO.getReview());
		pstmt.setInt(2, boardDTO.getReviewscore());
		pstmt.setInt(3, boardDTO.getProductnum());

		int result = pstmt.executeUpdate();

		closeConnection(pstmt, conn);

		return result;
		
	} // updateBoardReview
	
} // class
