//package vada.dao.impl;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.util.List;
//
//import vada.constants.VADAConstants;
//import vada.dto.ImgDTO;
//import vada.service.BoardImgService;
//
//public class BoardImgUpdateDAOImpl extends AbstractBoardImgDAO implements BoardImgService {
//
//	@Override
//	public int updateBoardImg(int userid, List<ImgDTO> imgDTOlist) throws Exception {
//		
//		Connection conn = getConnection();
//		
//		PreparedStatement pstmt = conn.prepareStatement(VADAConstants.props.getProperty("FILE_UPDATE_SQL"));<<얘가 존재하지않는데요?
//
//		int result = 0;
//		
//		if (imgDTOlist != null) {
//			
//			for (ImgDTO imgDTO : imgDTOlist) {
//				
////				pstmt.setString(1, imgDTO.getImgname());
//				pstmt.setString(2, imgDTO.getImgsname());
//				pstmt.setInt(3, imgDTO.getImgsize());
//				pstmt.setInt(5, userid);
//				
//				result = pstmt.executeUpdate();
//				
//				result = result * result;
//				
//			}
//			
//		}
//		
//		closeConnection(pstmt, conn);
//		
//		return result;
//		
//	}
//
//} // class
