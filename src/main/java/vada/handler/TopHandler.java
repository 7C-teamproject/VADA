package vada.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.CategoryListDAOImpl;
import vada.dto.CategoryDTO;
import vada.service.CategoryService;

public class TopHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		CategoryService categoryService = new CategoryListDAOImpl();
		List<CategoryDTO> categoryDTOList = categoryService.listCategory();
		request.setAttribute("categoryDTOList", categoryDTOList);
		
		
		
		return "jsp/top.jsp";

	}
	
}
