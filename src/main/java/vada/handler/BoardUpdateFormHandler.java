package vada.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import vada.dao.impl.BoardViewDAOImpl;
import vada.dao.impl.CategoryListDAOImpl;
import vada.dto.BoardDTO;
import vada.dto.CategoryDTO;
import vada.dto.ImgDTO;
import vada.dto.ProductpriceDTO;
import vada.service.BoardFileService;
import vada.service.BoardViewService;
import vada.service.CategoryService;

public class BoardUpdateFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {		
			List imgcnamelist = new ArrayList();
			List imgsizelist = new ArrayList();
			BoardDTO boardDTO = new BoardDTO();
		   ProductpriceDTO productpriceDTO = new ProductpriceDTO();
		      
		   boardDTO.setProductnum(Integer.parseInt(request.getParameter("productnum")));
		   boardDTO.setTitle(request.getParameter("title"));
		   boardDTO.setContent(request.getParameter("content"));
		      
		   productpriceDTO.setProductprice(Integer.parseInt(request.getParameter("productprice")));
		      
		   request.setAttribute("boardDTO", boardDTO);
		   request.setAttribute("productpriceDTO", productpriceDTO);


		for(int i=0; i<3; i++) {
			String imgcname = (String) request.getParameter("imgcname"+ String.valueOf(i));
			String imgsize = (String) request.getParameter("imgsize"+ String.valueOf(i));
			
			imgcnamelist.add(imgcname);
			imgsizelist.add(imgsize);
			
		}
		
		request.setAttribute("imgcnamelist", imgcnamelist);
		request.setAttribute("imgsizelist", imgsizelist);
		
		CategoryService categoryService = new CategoryListDAOImpl();
		List<CategoryDTO> categoryDTOList = null;
		try {
			categoryDTOList = categoryService.listCategory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("categoryDTOList", categoryDTOList);


		return "jsp/boardUpdateForm.jsp";
	}

}
