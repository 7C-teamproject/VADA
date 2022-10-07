package vada.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.CategoryListDAOImpl;
import vada.dto.CategoryDTO;
import vada.service.CategoryService;

public class BoardWriteFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

	 	CategoryService categoryService = new CategoryListDAOImpl();
	 	List<CategoryDTO> categoryDTOList = null;
		try {
			categoryDTOList = categoryService.listCategory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	request.setAttribute("categoryDTOList", categoryDTOList);

		return "/jsp/boardWriteForm.jsp";
	}
}
