package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vada.constants.VADAConstants;
import vada.dto.ImgDTO;

public class BoardImgViewDAOImpl extends AbstractBoardImgDAO {
	
	@Override
	public ImgDTO viewBoardImg(int imgnum) throws Exception {

		Connection conn = getConnection();
		String sql = VADAConstants.props.getProperty("FILE_VIEW_SQL");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, imgnum);
		ResultSet rs = pstmt.executeQuery();
		ImgDTO imgDTO = null;
		if (rs!=null && rs.next()) {
			imgDTO = new ImgDTO();
			imgDTO.setImgnum(rs.getInt("imgnum"));
			imgDTO.setImgcname(rs.getString("imgcname"));
			imgDTO.setImgsname(rs.getString("imgsname"));
			imgDTO.setImgsize(rs.getInt("imgsize"));
			imgDTO.setImgproductnum(rs.getInt("imgproductnum"));
		}
		closeConnection(rs, pstmt, conn);
		return imgDTO;		
		
	}

}
