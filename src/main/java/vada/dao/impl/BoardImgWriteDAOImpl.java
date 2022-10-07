package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import vada.constants.VADAConstants;
import vada.dto.ImgDTO;
import vada.dto.NotifyimgDTO;

public class BoardImgWriteDAOImpl extends AbstractBoardImgDAO {

	@Override
	public int writeBoardImg(int imgproductnum, ImgDTO ImgDTO) throws Exception {

		Connection conn = getConnection();
		String sql = VADAConstants.props.getProperty("FILE_WRITE_SQL");

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, imgproductnum);
		pstmt.setInt(2, ImgDTO.getImgnum());
		if(ImgDTO.getImgsname().length() < 42) {
	         pstmt.setString(3, ImgDTO.getImgsname());
	      } else {
	         pstmt.setString(3, ImgDTO.getImgsname().substring(42));
	      }
		pstmt.setInt(4, ImgDTO.getImgsize());
		pstmt.setString(5, ImgDTO.getImgcname());

		int result = pstmt.executeUpdate(); // 쿼리 실행 후 결과 반영 행 수 반환

		closeConnection(pstmt, conn);

		if(result==0) {
			System.out.println("디비에 안 들어감");
		} 

		return result;

	} // writeBoardFile(BoardFileDTO)

	public int notifyWriteBoardImg(int notifyid, NotifyimgDTO notifyImgDTO) throws Exception {
		Connection conn = getConnection();

		String sql = VADAConstants.props.getProperty("NOTIFY_IMG_WRITE_SQL");

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, notifyid);
		pstmt.setInt(2, notifyImgDTO.getNotifyimgnum());
		pstmt.setString(3, notifyImgDTO.getNotifyimgsname().substring(42));
		pstmt.setInt(4, notifyImgDTO.getNotifyimgsize());
		pstmt.setString(5, notifyImgDTO.getNotifyimgcname());

		int result = pstmt.executeUpdate(); // 쿼리 실행 후 결과 반영 행 수 반환

		closeConnection(pstmt, conn);

		return 0;
	}

} // class

// 함수가 어떻게 수행될지 써놓은 코드
// boardwriteProc.jsp 에서 이 함수를 호출해야됨
// BoardService boardWriteService = new BoardWriteDAOImpl();
// int result = boardWriteService.writeBoardImg(productnum(넣어줘야함), imgDTO); 
// if(result==0) { System.otu.print("디비에 안들어감"); } else { out.print("디비에 이미지 파일 넣기 성공");}
