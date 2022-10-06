package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import vada.constants.VADAConstants;
import vada.dto.ImgDTO;
import vada.service.BoardImgService;

public class BoardImgUpdateDAOImpl extends AbstractBoardImgDAO implements BoardImgService {

	@Override
	public int updateBoardImg(int userid, List<ImgDTO> list) throws Exception {
		Connection conn =getConnection();
		String sql = VADAConstants.props.getProperty("FILE_UPDATE_SQL");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int result = 0;
		if (list!=null) {
			for (ImgDTO imgDTO : list) {
//				pstmt.setString(1, imgDTO.getImgname());
				pstmt.setString(2, imgDTO.getImgsname());
				pstmt.setInt(3, imgDTO.getImgsize());
				pstmt.setInt(5, userid);
				result = pstmt.executeUpdate();
				result = result * result;
			}
		}
		closeConnection(pstmt, conn);
		return result;		
	}

} // class




