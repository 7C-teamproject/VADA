package vada.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vada.dao.impl.CategoryListDAOImpl;
import vada.dao.impl.UserInfoUpdateDAOImpl;
import vada.dto.CategoryDTO;
import vada.dto.UserDTO;
import vada.service.CategoryService;
import vada.service.UserInfoUpdateservice;

public class UserInfoUpdateFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		
		UserDTO userDTO = new UserDTO();
		
	 	CategoryService categoryService = new CategoryListDAOImpl();
	 	
	 	List<CategoryDTO> categoryDTOList = null;
		try {
			categoryDTOList = categoryService.getCategoryList();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	 	
	 	request.setAttribute("categoryDTOList", categoryDTOList);
	 	
	 	String userid=(String)session.getAttribute("userid");
	 	UserInfoUpdateservice userInfoUpdateservice = new UserInfoUpdateDAOImpl();
	 	
	 	try {
			userDTO = userInfoUpdateservice.UserInfoSelect(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 	
	 	request.setAttribute("userDTO", userDTO);
		return "/jsp/userInfoUpdateForm.jsp";
	}

}
