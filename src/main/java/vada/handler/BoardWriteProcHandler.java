package vada.handler;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import vada.dao.impl.BoardImgWriteDAOImpl;
import vada.dao.impl.BoardProductNumDAOImpl;
import vada.dao.impl.BoardWriteDAOImpl;
import vada.dto.BoardDTO;
import vada.dto.ImgDTO;
import vada.service.BoardFileService;
import vada.service.BoardImgService;
import vada.service.BoardProductNumService;
import vada.service.BoardWriteService;

public class BoardWriteProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSellerid(request.getParameter("sellerid"));
		boardDTO.setTitle(request.getParameter("title"));
		boardDTO.setContent("content");
		boardDTO.setBcategorynum(Integer.parseInt(request.getParameter("bcategorynum")));
		
		HttpSession session = request.getSession();
		
		boardDTO.setSellerid((String)session.getAttribute("userid"));
		
		BoardWriteService boardWriteService = new BoardWriteDAOImpl();
		BoardImgService boardImgService = new BoardImgWriteDAOImpl();

		// 제품 테이블 작성
		try {
			int result = boardWriteService.writeBoard(boardDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 가장 마지막에 작성된 제품아이디 가져오기
		int productNum = 0;
		try {
			productNum = new BoardProductNumDAOImpl().getProductNum();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 가격 테이블 작성
		try {
			boardWriteService.writePrice(productNum, Integer.parseInt(request.getParameter("productprice")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 이미지 파일 처리 및 작성
		Collection<Part> parts = null;
		try {
			parts = request.getParts();
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<String> imgsnameList = (List<String>) request.getAttribute("imgsnameList");
		
		int listIndex = 0;
		   
		   ImgDTO imgDTO = null;
		   
		   for (Part part : parts) {
		         imgDTO = new ImgDTO();
		         
		      if (part.getHeader("Content-Disposition").contains("filename=") && part.getSize() > 0) {
		         imgDTO.setImgcname(part.getSubmittedFileName());
		         imgDTO.setImgsname(imgsnameList.get(listIndex));
		         imgDTO.setImgsize((int) part.getSize());
		         imgDTO.setImgnum(listIndex + 1);
		         
		         try {
					boardImgService.writeBoardImg(productNum, imgDTO);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         listIndex++;
		      }
		      
		   }
		   
		   if(listIndex==0) {
		      imgDTO = new ImgDTO();
		      imgDTO.setImgcname("defaultcname");
		      imgDTO.setImgsname("img/no-image.jpg");
		      imgDTO.setImgsize(1);
		      imgDTO.setImgnum(1);
		      try {
				boardImgService.writeBoardImg(productNum, imgDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		
		return "/jsp/mainformindex.jsp";
	}

}
