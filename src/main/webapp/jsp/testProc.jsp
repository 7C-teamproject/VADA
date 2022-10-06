<%@page import="vada.dto.BoardDTO"%>
<%@page import="vada.dto.ImgDTO"%>
<%@page import="java.util.List"%>
<%@page import="vada.dao.impl.BoardImgWriteDAOImpl"%>
<%@page import="vada.dao.impl.BoardWriteDAOImpl"%>
<%@page import="vada.service.BoardWriteService"%>
<%@page import="vada.service.BoardImgService"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// BoardDTO boardDTO = new BoardDTO();
// boardDTO.setBtitle(request.getParameter("btitle") == null ? "" : request.getParameter("btitle"));
// boardDTO.setBdomain(request.getParameter("bdomain") == null ? "" : request.getParameter("bdomain"));
// boardDTO.setBcontent(request.getParameter("bcontent") == null ? "" : request.getParameter("bcontent"));
// boardDTO.setBwriterid("anonymous");

// BoardWriteService boardWriteService = new BoardWriteDAOImpl();
// try {
// 	boardWriteService.writeBoard(boardDTO);
// } catch (Exception ex) {
// 	ex.printStackTrace();
// }

// BoardIDService boardIDService = new BoardIDDAOImpl();
// int bid = 0;
// try {
// 	bid = boardIDService.getBID();
// } catch (Exception ex) {
// 	ex.printStackTrace();
// }

BoardImgService boardImgService = new BoardImgWriteDAOImpl();
Collection<Part> parts = null;
try {
	parts = request.getParts();
} catch (Exception ex) {

}
List<String> sfnList = (List<String>) request.getAttribute("sfnList");
int listIndex = 0;
for (Part part : parts) {
	if (part.getHeader("Content-Disposition").contains("filename=") && part.getSize() > 0) {
		ImgDTO imgDTO = new ImgDTO();
		imgDTO.setImgcname(part.getSubmittedFileName());
		imgDTO.setImgsname(sfnList.get(listIndex));
		imgDTO.setImgsize((int) part.getSize());
		try {
			boardImgService.writeBoardImg(71, imgDTO);
		} catch (Exception ex) {
	ex.printStackTrace();
		}
		listIndex++;
	}
}
response.sendRedirect("/Vada/jsp/mainForm.jsp");
%>