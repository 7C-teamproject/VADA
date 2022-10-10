package vada.handler;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import vada.dao.impl.BoardImgWriteDAOImpl;
import vada.dao.impl.BoardWriteDAOImpl;
import vada.dto.NotifyimgDTO;
import vada.dto.NotifylistDTO;
import vada.service.BoardImgService;
import vada.service.BoardWriteService;

public class NotifyWriteProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		BoardWriteService notifyWriteService = new BoardWriteDAOImpl();
		String userid = (String) session.getAttribute("userid");

		int notifyProductNum = Integer.parseInt(request.getParameter("productnum") == null ? "" : (String) request.getParameter("productnum"));
		NotifylistDTO notifyDTO = new NotifylistDTO();
		notifyDTO.setNotifyreason(request.getParameter("notifyreason"));
		
		int result = 0; // DB 작성완료시 0<result
		try {
			result = notifyWriteService.notifyWriteBoard(notifyDTO, notifyProductNum, userid);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		int notifyid = 0;
		try {
			notifyid = notifyWriteService.get_Notifyid();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		BoardImgService notifyImgService = new BoardImgWriteDAOImpl();
		Collection<Part> parts = null;
		try {
			parts = request.getParts();
		} catch (Exception ex) {

		}

		// 신고 첨부파일 파일 처리
		List<String> imgsnameList = (List<String>) request.getAttribute("imgsnameList");
		int listIndex = 0;
		for (Part part : parts) {
			if (part.getHeader("Content-Disposition").contains("filename=") && part.getSize() > 0) {
				NotifyimgDTO notifyImgDTO = new NotifyimgDTO();
				notifyImgDTO.setNotifyimgcname(part.getSubmittedFileName());
				notifyImgDTO.setNotifyimgsname(imgsnameList.get(listIndex));
				notifyImgDTO.setNotifyimgnum(listIndex + 1);
				notifyImgDTO.setNotifyimgsize((int) part.getSize());
				try {
					notifyImgService.notifyWriteBoardImg(notifyid, notifyImgDTO);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				listIndex++;
			}
		}

		return "/jsp/mainFormIndex.jsp";
	}

}
