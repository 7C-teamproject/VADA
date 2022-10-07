package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import vada.constants.VADAConstants;
import vada.dao.BoardUpdateDAO;
import vada.dto.BoardDTO;
import vada.dto.CategoryDTO;
import vada.dto.ProductpriceDTO;

public class BoardUpdateDAOImpl extends BoardDAOImpl implements BoardUpdateDAO {

	@Override
	public int updateBoard(int productnum, BoardDTO boardDTO, ProductpriceDTO productpriceDTO,
			CategoryDTO categoryDTO) {
		// 게시판 업데이트

		Connection conn = getConnection();

		// 1. setAutoCommit(false)로 설정 : 트랜잭션이 끝날 때까지 commit 하지 않는다.(트랜잭션 작성 시작)
		if (conn != null) {
			try {
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;

		int result1 = 0;
		int result2 = 0;
		int result3 = 0;

		try {
			pstmt1 = conn.prepareStatement(VADAConstants.props.getProperty("UPDATE_BOARD_SQL"));
			pstmt2 = conn.prepareStatement(VADAConstants.props.getProperty("UPDATE_PRODUCTPRICE_SQL"));
			pstmt3 = conn.prepareStatement(VADAConstants.props.getProperty("UPDATE_CATEGORY_SQL"));

			pstmt1.setString(1, boardDTO.getTitle());
			pstmt1.setString(2, boardDTO.getContent());
			pstmt1.setInt(3, productnum);

			// UPDATE_BOARD_SQL=update board set title=?, wdate=now(), content="?" where
			// productnum =?;

			// 제품가격 업데이트
			pstmt2.setInt(1, productpriceDTO.getProductprice());
			pstmt2.setInt(2, productnum);

			// UPDATE_PRODUCTPRICE_SQL=update productprice set productprice=? where
			// productpricenum =?;

			// 카테고리업데이트
			pstmt3.setInt(1, boardDTO.getBcategorynum());
			pstmt3.setInt(2, productnum);

			// UPDATE_CATEGORY_SQL=update board set bcategorynum=? where productnum =?;

			result1 = pstmt1.executeUpdate();
			result2 = pstmt2.executeUpdate();
			result3 = pstmt3.executeUpdate();

			if (result1 > 0) {
				System.out.println("수행 성공~");
			}
			if (result2 > 0) {
				System.out.println("수행 성공~");
			}
			if (result3 > 0) {
				System.out.println("수행 성공~");
			}

			conn.commit();

		} catch (SQLException sqle) {
			sqle.printStackTrace();

			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		finally {
			if (pstmt3 != null) {
				closeConnection(pstmt3, getConnection());
			}
			if (pstmt2 != null) {
				closeConnection(pstmt2, getConnection());
			}
			if (pstmt1 != null) {
				closeConnection(pstmt1, conn);
			}
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			

		}
		
		return result1 * result2 * result3;

	}
}

// class
