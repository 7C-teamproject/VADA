package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import vada.constants.CommonConstants;
import vada.constants.VADAConstants;
import vada.dto.ImgDTO;
import vada.dto.NotifyimgDTO;

public class BoardImgWriteDAOImpl extends AbstractBoardImgDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;

	@Override
	public int writeBoardImg(int imgproductnum, ImgDTO imgDTO) throws Exception {

		conn = getConnection();

		// insert into img (imgproductnum, imgnum, imgsname, imgsize, imgcname) values (?, ?, ?, ?, ?)
		pstmt = conn.prepareStatement(VADAConstants.props.getProperty("INSERT_IMG_SQL"));

		pstmt.setInt(1, imgproductnum);
		pstmt.setInt(2, imgDTO.getImgnum());

		String[] imgsname = imgDTO.getImgsname().split("img");
		pstmt.setString(3, imgsname[1]);

		pstmt.setInt(4, imgDTO.getImgsize());
		pstmt.setString(5, imgDTO.getImgcname());

		int result = pstmt.executeUpdate();

		closeConnection(pstmt, conn);

		return result;

	} // writeBoardImg

	public int notifyWriteBoardImg(int notifyid, NotifyimgDTO notifyImgDTO) throws Exception {
		conn = getConnection();

		// NOTIFY_IMG_WRITE_SQL
		pstmt = conn.prepareStatement(VADAConstants.props.getProperty("NOTIFY_IMG_WRITE_SQL"));
		
		pstmt.setInt(1, notifyid);
		pstmt.setInt(2, notifyImgDTO.getNotifyimgnum());
		
		String[] notifyimgsname = notifyImgDTO.getNotifyimgsname().split("img");
		pstmt.setString(3, notifyimgsname[1]);
		
		pstmt.setInt(4, notifyImgDTO.getNotifyimgsize());
		pstmt.setString(5, notifyImgDTO.getNotifyimgcname());

		int result = pstmt.executeUpdate();

		closeConnection(pstmt, conn);

		return result;
		
	} // notifyWriteBoardImg

} // class
