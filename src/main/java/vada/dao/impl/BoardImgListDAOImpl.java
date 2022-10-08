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
	public List<ImgDTO> getBoardImgList(int productnum) throws Exception {

		Connection conn = getConnection();
		
		// select * from img where imgproductnum=? order by imgnum 
		PreparedStatement pstmt = conn.prepareStatement(VADAConstants.props.getProperty("SELECT_IMG_SQL"));

		pstmt.setInt(1, productnum);
		
		ResultSet rs = pstmt.executeQuery();
		
		List<ImgDTO> imgDTOList = null;
		
		if (rs != null && rs.next()) {
			
			imgDTOList = new ArrayList<ImgDTO>();
			
			while (rs.next()) {
				
				ImgDTO imgDTO = new ImgDTO();
				
				imgDTO.setImgnum(rs.getInt("imgnum"));
				imgDTO.setImgcname(rs.getString("imgcname"));
				imgDTO.setImgsname(rs.getString("imgsname"));
				imgDTO.setImgsize(rs.getInt("imgsize"));
				imgDTO.setImgproductnum(rs.getInt("imgproductnum"));
				
				imgDTOList.add(imgDTO);
				
			}
			
		}
		
		closeConnection(rs, pstmt, conn);
		
		return imgDTOList;

	} // getBoardImgList

} // class
