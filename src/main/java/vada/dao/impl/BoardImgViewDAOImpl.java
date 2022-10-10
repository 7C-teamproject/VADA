//package vada.dao.impl;
//TODO 안쓰는 거 같음
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import vada.constants.VADAConstants;
//import vada.dto.ImgDTO;
//
//public class BoardImgViewDAOImpl extends AbstractBoardImgDAO {
//
//	@Override
//	public ImgDTO viewBoardImg(int imgnum) throws Exception {		
//
//		Connection conn = getConnection();
//
//		//select * from img where imgproductnum=? order by imgnum
//		PreparedStatement pstmt = conn.prepareStatement(VADAConstants.props.getProperty("SELECT_FILE_VIEW_SQL"));
//
//		pstmt.setInt(1, imgnum);
//
//		ResultSet rs = pstmt.executeQuery();
//
//		ImgDTO imgDTO = null;
//
//		// ImgDTO에 데이터 저장
//		if (rs != null && rs.next()) {
//
//			imgDTO = new ImgDTO();
//
//			imgDTO.setImgnum(rs.getInt("imgnum"));
//			imgDTO.setImgcname(rs.getString("imgcname"));
//			imgDTO.setImgsname(rs.getString("imgsname"));
//			imgDTO.setImgsize(rs.getInt("imgsize"));
//			imgDTO.setImgproductnum(rs.getInt("imgproductnum"));
//
//		}
//
//		closeConnection(rs, pstmt, conn);
//
//		return imgDTO;
//
//	}
//
//}
