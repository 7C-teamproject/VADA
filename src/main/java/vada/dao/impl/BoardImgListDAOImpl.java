package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vada.constants.VADAConstants;
import vada.dto.ImgDTO;

public class BoardImgListDAOImpl extends AbstractBoardImgDAO {

	@Override
	public List<ImgDTO> listBoardImg(int productnum) throws Exception {
		
		Connection conn = getConnection();
		String sql = VADAConstants.props.getProperty("FILE_LIST_SQL");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, productnum);
		ResultSet rs = pstmt.executeQuery();
		List<ImgDTO> list = null;
		if (rs!=null && rs.next()) {
			list = new ArrayList<ImgDTO>();
			while (rs.next()) {
				ImgDTO imgDTO = new ImgDTO();
				imgDTO.setImgnum(rs.getInt("imgnum"));
				imgDTO.setImgcname(rs.getString("imgcname"));
				imgDTO.setImgsname(rs.getString("imgsname"));
				imgDTO.setImgsize(rs.getInt("imgsize"));
				imgDTO.setImgproductnum(rs.getInt("imgproductnum"));	
				list.add(imgDTO);
			}
		}
		closeConnection(rs, pstmt, conn);
		return list;
		
	} // listBoardFile()

} // class
