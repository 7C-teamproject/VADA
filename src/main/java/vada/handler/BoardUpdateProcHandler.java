package vada.handler;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import vada.dao.impl.BoardImgDeleteDAOImpl;
import vada.dao.impl.BoardImgWriteDAOImpl;
import vada.dao.impl.BoardUpdateDAOImpl;
import vada.dto.BoardDTO;
import vada.dto.CategoryDTO;
import vada.dto.ImgDTO;
import vada.dto.ProductpriceDTO;
import vada.service.BoardFileService;
import vada.service.BoardImgService;
import vada.service.BoardUpdateService;

public class BoardUpdateProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("updateprochandler @@@@" + request.getParameter("bcategorynum2"));
		
		int productnum = Integer.parseInt(request.getParameter("productnum"));
		
		// 기존 이미지 삭제(DB)
		BoardImgService boardImgDeleteService = new BoardImgDeleteDAOImpl();
		try {
			boardImgDeleteService.deleteBoardImg(productnum);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		// 이미지 파일 처리 및 작성(DB에 이미지 경로 imgsname 넣음)
		Collection<Part> parts = null;
		try {
			parts = request.getParts();
		} catch (IOException | ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		List<String> imgsnameList = (List<String>) request.getAttribute("imgsnameList");
			
		int listIndex = 0;
		
		BoardImgService boardImgWriteService = new BoardImgWriteDAOImpl();
		
		ImgDTO imgDTO = new ImgDTO();
		BoardDTO boardDTO = new BoardDTO();
		CategoryDTO categoryDTO = new CategoryDTO();
		ProductpriceDTO productpriceDTO = new ProductpriceDTO();
		
		boardDTO.setTitle(request.getParameter("title"));
		boardDTO.setContent(request.getParameter("content"));
		boardDTO.setProductnum(Integer.parseInt(request.getParameter("productnum")));
		boardDTO.setBcategorynum(Integer.parseInt(request.getParameter("bcategorynum2")));
		productpriceDTO.setProductprice(Integer.parseInt(request.getParameter("productprice")));
		
		
		
		for (Part part : parts) {
			if (part.getHeader("Content-Disposition").contains("filename=") && part.getSize() > 0) {
				
				imgDTO.setImgcname(part.getSubmittedFileName());
				imgDTO.setImgsname(imgsnameList.get(listIndex));
				imgDTO.setImgsize((int) part.getSize());
				imgDTO.setImgnum(listIndex + 1);
					
				try {
					boardImgWriteService.writeBoardImg(productnum, imgDTO);
				} catch (Exception e) {
					e.printStackTrace();
				} // 디비에 이미지 저장하는 impl 호출
					
				listIndex++;
			}
		}	
		
		BoardUpdateService boardUpdateService = new BoardUpdateDAOImpl();
		int result = 0;
		try {
			result = boardUpdateService.updateBoard(productnum, boardDTO, productpriceDTO, categoryDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		if(result==0) {
//			System.out.println("게시글 수정 안 됨((실패)) 이미지는 모름");
//		} else {
//			System.out.println("게시글 수정 완료 이미지는 모름");
//			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/boardDetailForm.jsp");
//			try {
//				dispatcher.forward(request, response);
//			} catch (ServletException | IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	

		return "/jsp/mainformindex.jsp?productnum="+productnum;
	}

}
