package vada.handler;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.BoardDeleteDAOImpl;

//import vada.dto.BoardFileDTO;

public class BoardDeleteProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		Integer bid = Integer.parseInt(request.getParameter("bid") == null ? "" : request.getParameter("bid"));
//		List<BoardFileDTO> boardFileDTOList = null;
//		try {
//			boardFileDTOList = new BoardFileListDAOImpl().listBoardFile(bid);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		for (BoardFileDTO boardFileDTO : boardFileDTOList) {
//			File file = new File(boardFileDTO.getBfsfn());
//			if (file.exists()) {
//				file.delete();
//			}
//		}
//		try {
//			new BoardFileDeleteDAOImpl().deleteBoardFiles(bid);
//			new BoardDeleteDAOImpl().deleteBoard(bid);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
		return "/boardlist.do";
	}

}
