<%@page import="vada.dao.impl.BoardImgWriteDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collection"%>
<%@page import="vada.dao.impl.BoardImgDeleteDAOImpl"%>
<%@page import="vada.service.BoardImgService"%>
<%@page import="vada.dto.ImgDTO"%>
<%@page import="vada.dto.ProductpriceDTO"%>
<%@page import="vada.dto.BoardDTO"%>
<%@page import="java.util.Map"%>
<%@page import="vada.dao.impl.BoardUpdateDAOImpl"%>
<%@page import="vada.service.BoardUpdateService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="boardDTO" class="vada.dto.BoardDTO"  />
<jsp:useBean id="productpriceDTO" class="vada.dto.ProductpriceDTO"  />
<jsp:useBean id="categoryDTO" class="vada.dto.CategoryDTO"  />
<jsp:useBean id="imgDTO" class="vada.dto.ImgDTO"  />

<jsp:setProperty name="boardDTO" property="*" />
<jsp:setProperty name="productpriceDTO" property="*" />
<jsp:setProperty name="imgDTO" property="*" />

<% 

	int productnum = Integer.parseInt(request.getParameter("productnum"));

	System.out.println("boardUpdateProc.jsp : productnum============>" + productnum);
	
	// 기존 이미지 삭제(DB)
	BoardImgService boardImgDeleteService = new BoardImgDeleteDAOImpl();
	boardImgDeleteService.deleteBoardImg(productnum);
	
	// 이미지 파일 처리 및 작성(DB에 이미지 경로 imgsname 넣음)
	Collection<Part> parts = request.getParts();
		
	List<String> imgsnameList = (List<String>) request.getAttribute("imgsnameList");
		
	int listIndex = 0;
	
	BoardImgService boardImgWriteService = new BoardImgWriteDAOImpl();
	
	for (Part part : parts) {
		if (part.getHeader("Content-Disposition").contains("filename=") && part.getSize() > 0) {
			
			System.out.println("imgDTO================================>" + imgDTO);
			
			imgDTO.setImgcname(part.getSubmittedFileName());
			imgDTO.setImgsname(imgsnameList.get(listIndex));
			imgDTO.setImgsize((int) part.getSize());
			imgDTO.setImgnum(listIndex + 1);
				
			boardImgWriteService.writeBoardImg(productnum, imgDTO); // 디비에 이미지 저장하는 impl 호출
				
			listIndex++;
		}
	}
	
	System.out.println("boardUpdateProc.jsp=================================");
	System.out.println("boardDTO============" + boardDTO);
	System.out.println("productpriceDTO============" + productpriceDTO);
	System.out.println("categoryDTO============" + categoryDTO);
	
	
	
	
	
	
	BoardUpdateService boardUpdateService = new BoardUpdateDAOImpl();
	int result = boardUpdateService.updateBoard(productnum, boardDTO, productpriceDTO, categoryDTO);
	
	if(result==0) {
		System.out.println("게시글 수정 안 됨((실패)) 이미지는 모름");
	} else {
		System.out.println("게시글 수정 완료 이미지는 모름");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/boardDetailForm.jsp");
		dispatcher.forward(request, response);
	}
	

%>

