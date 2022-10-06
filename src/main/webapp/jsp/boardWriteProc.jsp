<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="vada.dao.impl.BoardProductNumDAOImpl"%>
<%@ page import="vada.service.BoardProductNumService"%>
<%@ page import="java.util.Collection"%>
<%@ page import="vada.dao.impl.BoardImgWriteDAOImpl"%>
<%@ page import="vada.service.BoardImgService"%>
<%@ page import="vada.dto.ImgDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.io.Console"%>
<%@ page import="vada.dto.BoardDTO"%>
<%@ page import="vada.dao.impl.BoardWriteDAOImpl"%>
<%@ page import="vada.service.BoardWriteService"%>

<jsp:useBean id="boardDTO" class="vada.dto.BoardDTO" />
<jsp:setProperty name="boardDTO" property="*" />

<jsp:setProperty name="boardDTO" property="buyerid" value="default" /><% // TODO 이거는 게시글 판매 완료 처리되면 작성 %>
<%
	boardDTO.setSellerid((String)session.getAttribute("userid"));
	
	BoardWriteService boardWriteService = new BoardWriteDAOImpl();
	BoardImgService boardImgService = new BoardImgWriteDAOImpl();

	// 제품 테이블 작성
	int result = boardWriteService.writeBoard(boardDTO);
	
	// 가장 마지막에 작성된 제품아이디 가져오기
	int productNum = new BoardProductNumDAOImpl().getProductNum();
	
	// 가격 테이블 작성
	boardWriteService.writePrice(productNum, Integer.parseInt(request.getParameter("productprice")));
	
	
	// 이미지 파일 처리 및 작성
	Collection<Part> parts = request.getParts();

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
	         
	         boardImgService.writeBoardImg(productNum, imgDTO);
	         listIndex++;
	      }
	      
	   }
	   
	   if(listIndex==0) {
	      imgDTO = new ImgDTO();
	      imgDTO.setImgcname("defaultcname");
	      imgDTO.setImgsname("img/no-image.jpg");
	      imgDTO.setImgsize(1);
	      imgDTO.setImgnum(1);
	      boardImgService.writeBoardImg(productNum, imgDTO);
	   }
	
	response.sendRedirect("/Vada/jsp/mainForm.jsp");
%>