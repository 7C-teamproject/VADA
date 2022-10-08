package vada.handler;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vada.dao.impl.UserInfoUpdateDAOImpl;
import vada.dto.UserDTO;
import vada.service.UserInfoUpdateservice;

public class UserInfoUpdateProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		UserDTO userDTO = new UserDTO();
		
		userDTO.setAddress(request.getParameter("address"));
		userDTO.setDetailaddress(request.getParameter("detailaddress"));
		userDTO.setEmail(request.getParameter("email"));
		userDTO.setName(request.getParameter("name"));
		userDTO.setInterestcategorynum(Integer.parseInt(request.getParameter("interestcategorynum")));
		userDTO.setNickname("nickname");
		userDTO.setTel("tel");
		userDTO.setUserpw(request.getParameter("userpw"));
		
		
		UserInfoUpdateservice userInfoUpdateservice = new UserInfoUpdateDAOImpl();
	    String userid=(String)session.getAttribute("userid");
	    System.out.println("UserDTO Proc.jsp : " + userDTO);
	    
	    try {
			userInfoUpdateservice.UserInfoUpdate(userid, userDTO);
		} catch (SQLException e) {

			e.printStackTrace();
		}

//	    RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/loginForm.jsp");
//		dispatcher.forward(request, response);

		return "/jsp/loginForm.jsp";
	}

}
