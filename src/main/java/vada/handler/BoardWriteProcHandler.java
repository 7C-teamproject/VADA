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

		HttpSession session = request.getSession();

		BoardDTO boardDTO = new BoardDTO();

		boardDTO.setSellerid((String)session.getAttribute("userid"));
		boardDTO.setTitle(request.getParameter("title"));
		boardDTO.setContent(request.getParameter("content"));
		boardDTO.setBcategorynum(Integer.parseInt(request.getParameter("bcategorynum")));

		BoardWriteService boardWriteService = new BoardWriteDAOImpl();
		BoardImgService boardImgService = new BoardImgWriteDAOImpl();

		int result = 0;
		int productNum = 0;
		Collection<Part> parts = null;
		int listIndex = 0;
		ImgDTO imgDTO = null;
		List<String> imgsnameList = (List<String>) request.getAttribute("imgsnameList");
		
		try {

			// 제품 테이블 작성
			result = boardWriteService.writeBoard(boardDTO);

			// 가장 마지막에 작성된 제품아이디 가져오기
			productNum = new BoardProductNumDAOImpl().getProductNum();

			// 가격 테이블 작성
			boardWriteService.writePrice(productNum, Integer.parseInt(request.getParameter("productprice")));

			// 이미지 파일 처리 및 작성
			parts = request.getParts();

			for (Part part : parts) {
				imgDTO = new ImgDTO();

				if (part.getHeader("Content-Disposition").contains("filename=") && part.getSize() > 0) {
					imgDTO.setImgcname(part.getSubmittedFileName());
					imgDTO.setImgsname(imgsnameList.get(listIndex));
					imgDTO.setImgsize((int) part.getSize());
					imgDTO.setImgnum(listIndex + 1);

					boardImgService.writeBoardImg(productNum, imgDTO);
					
					listIndex++;
				}

			}
			
			// 게시글 작성 시 이미지를 선택하지 않았을 때 default 이미지로 DB에 저장
			if (listIndex == 0) {
				imgDTO = new ImgDTO();
				imgDTO.setImgcname("defaultcname");
				imgDTO.setImgsname("img/no-image.jpg");
				imgDTO.setImgsize(1);
				imgDTO.setImgnum(1);
				
				boardImgService.writeBoardImg(productNum, imgDTO);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/jsp/mainformindex.jsp";
	}

}
