//package vada.handler;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import vada.dao.impl.BoardViewDAOImpl;
//import vada.dto.BoardDTO;
//import vada.dto.ImgDTO;
//import vada.service.BoardFileService;
//import vada.service.BoardViewService;
//
//public class BoardUpdateFormHandler implements CommandHandler {
//
//	@Override
//	public String process(HttpServletRequest request, HttpServletResponse response) {
//
//		String bidParam = request.getParameter("bid") == null ? "" : request.getParameter("bid");
//		BoardViewService boardViewService = new BoardViewDAOImpl();
//		BoardDTO boardDTO = null;
//		try {
//			boardDTO = boardViewService.viewBoard(Integer.parseInt(bidParam));
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		request.setAttribute("boardDTO", boardDTO);
//
////		BoardFileService boardFileService = new BoardFileListDAOImpl();
//		List<ImgDTO> boardFileDTOList = null;
////		try {
////			boardFileDTOList = boardFileService.listBoardFile(Integer.parseInt(bidParam));
////			request.setAttribute("boardFileDTOList", boardFileDTOList);
////		} catch (Exception ex) {
////			ex.printStackTrace();
////		}
//
//		return "/jsp/updateBoardForm.jsp";
//	}
//
//}
