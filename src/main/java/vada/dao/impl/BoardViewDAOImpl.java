package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vada.constants.VADAConstants;
import vada.dao.BoardViewDAO;
import vada.dto.BoardDTO;
import vada.dto.CategoryDTO;
import vada.dto.ImgDTO;
import vada.dto.NotifyimgDTO;
import vada.dto.NotifylistDTO;
import vada.dto.ProductpriceDTO;

public class BoardViewDAOImpl extends BoardDAOImpl implements BoardViewDAO {
	@Override
	public Map<String, Object> viewBoard(int productnum) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

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
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;

		try {
			
			pstmt1 = conn.prepareStatement(VADAConstants.props.getProperty("SELECT_BOARD_PRICE_SQL"));
			pstmt2 = conn.prepareStatement(VADAConstants.props.getProperty("SELECT_BOARD_CATEGORY_SQL"));
			pstmt3 = conn.prepareStatement(VADAConstants.props.getProperty("SELECT_BOARD_IMG_SQL"));

			pstmt1.setInt(1, productnum);
			pstmt2.setInt(1, productnum);
			pstmt3.setInt(1, productnum);

			rs1 = pstmt1.executeQuery();
			rs2 = pstmt2.executeQuery();
			rs3 = pstmt3.executeQuery();
			
			BoardDTO boardDTO = null;
			ProductpriceDTO productDTO = null;
			CategoryDTO categoryDTO = null;
			ImgDTO imgDTO = null;

			if (rs1 != null && rs1.next()) {

				boardDTO = new BoardDTO();
				productDTO = new ProductpriceDTO();

				boardDTO.setTitle(rs1.getString("title"));
				boardDTO.setBcategorynum(rs1.getInt("bcategorynum"));
				boardDTO.setContent(rs1.getString("content"));
				boardDTO.setProductnum(productnum);
				boardDTO.setReservation(rs1.getString("reservationyn"));
				boardDTO.setBuyerid(rs1.getString("buyerid"));  //TODO 고쳤음@
				boardDTO.setSellerid(rs1.getString("sellerid"));	//TODO 고쳤음@
				boardDTO.setReserveid(rs1.getString("reserveid"));
				boardDTO.setSoldoutdate(rs1.getTimestamp("soldoutdate"));
				
				boardDTO.setReview(rs1.getString("review"));
				boardDTO.setReviewscore(rs1.getInt("reviewscore"));

				productDTO.setProductprice(rs1.getInt("productprice"));
			}

			if (rs2 != null && rs2.next()) {
				categoryDTO = new CategoryDTO();
				categoryDTO.setCategoryname(rs2.getString("categoryname"));
			}

			List list1 = new ArrayList();
			List list2 = new ArrayList();
			List list3 = new ArrayList();

			while (rs3 != null && rs3.next()) {
				imgDTO = new ImgDTO();

				imgDTO.setImgsname(rs3.getString("imgsname"));
				imgDTO.setImgcname(rs3.getString("imgcname"));
				imgDTO.setImgsize(rs3.getInt("imgsize"));

				list1.add(imgDTO.getImgsname());
				list2.add(imgDTO.getImgcname());
				list3.add(imgDTO.getImgsize());

			}

			map.put("boardDTO", boardDTO);
			map.put("ProductpriceDTO", productDTO);
			map.put("categoryDTO", categoryDTO);
			
			map.put("imglist1", list1);
			map.put("imglist2", list2);
			map.put("imglist3", list3);
			
		conn.commit();

	} catch (SQLException e) {
		e.printStackTrace();

		try {
			conn.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	} finally {
		if (rs3 != null) {
			closeConnection(rs1, pstmt1);
		}
		if (rs2 != null) {
			closeConnection(rs1, pstmt1);
		}
		if (rs1 != null) {
			closeConnection(rs1, pstmt1, conn);
		}
		try {
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	return map;

	} // viewBoard

	@Override
	public Map<String, Object> notifyView(int notifyid) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		Connection conn = getConnection();
		PreparedStatement pstmt1 = conn.prepareStatement(VADAConstants.props.getProperty("NOTIFY_VIEW_SQL"));
		pstmt1.setInt(1, notifyid);

		PreparedStatement pstmt2 = conn.prepareStatement(VADAConstants.props.getProperty("NOTIFY_IMG_VIEW_SQL"));
		pstmt2.setInt(1, notifyid);

		ResultSet rs1 = pstmt1.executeQuery();
		ResultSet rs2 = pstmt2.executeQuery();

		NotifylistDTO notifylistDTO = null;

		if (rs1 != null && rs1.next()) {

			notifylistDTO = new NotifylistDTO();

			notifylistDTO.setNotifyreason(rs1.getString("notifyreason"));
			notifylistDTO.setNotifyuserid(rs1.getString("notifyuserid"));
			notifylistDTO.setNotifyid(rs1.getInt("notifyid"));
			notifylistDTO.setNotifydate(rs1.getTimestamp("notifydate"));
			notifylistDTO.setNotifyproductnum(rs1.getInt("notifyproductnum"));
		}

		List<String> list = new ArrayList<String>();
		while (rs2 != null && rs2.next()) {
			list.add(rs2.getString("notifyimgsname"));
		}

		map.put("notifylistDTO", notifylistDTO);
		map.put("imglist", list);

		closeConnection(rs1, pstmt1, conn);
		closeConnection(rs2, pstmt2);

		return map;
	}
	public int reserveBoard(int productnum, String command, String userid) throws Exception {
		Connection conn = getConnection();
		
		PreparedStatement pstmt = null;
		
		if(command.equals("reserve")) {
			pstmt = conn.prepareStatement(VADAConstants.props.getProperty("YES_RESERVE_BOARD_SQL"));
			pstmt.setString(1,userid);
			pstmt.setInt(2, productnum);
		}else {
			pstmt = conn.prepareStatement(VADAConstants.props.getProperty("NO_RESERVE_BOARD_SQL"));
			pstmt.setInt(1, productnum);
		}
		
		int result = pstmt.executeUpdate();
		
		closeConnection(pstmt, conn);
		return result;
	}
} // class