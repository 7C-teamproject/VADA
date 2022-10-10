package vada.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.JoinDAOImpl;
import vada.dto.UserDTO;
import vada.service.JoinService;

public class JoinProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		JoinService joinService = new JoinDAOImpl();

		UserDTO userDTO = new UserDTO();
		userDTO.setAddress(request.getParameter("address"));
		userDTO.setDetailaddress(request.getParameter("detailaddress"));
		userDTO.setEmail(request.getParameter("email"));
//		userDTO.setInterestcategorynum(Integer.parseInt(request.getParameter("bcategorynum")));
		userDTO.setNickname(request.getParameter("nickname"));
		userDTO.setTel(request.getParameter("tel"));
		userDTO.setUserpw(request.getParameter("userpw"));
		userDTO.setUserid(request.getParameter("userid"));
		userDTO.setName(request.getParameter("name"));

		System.out.println(userDTO);

		boolean checkUserID = false;
		boolean checkNickName = false;
		String url = "";
		int result = 0;
		
		try {
			checkUserID = joinService.checkUserid(userDTO.getUserid());

			checkNickName = joinService.checkUserid(userDTO.getNickname());

			if (checkUserID == true && checkNickName == true) {
				System.out.println("중복 아이디 없음 - 회원가입 성공");
				result = joinService.join(userDTO);
				url = "/jsp/loginForm.jsp";
			} else if (checkUserID == false) {
				System.out.println("중복 아이디 존재함 - 회원가입 실패");
				url = "/jsp/duplicateUserInfo.jsp";
			} else if (checkNickName == false) {
				System.out.println("중복 닉네임 존재함 - 회원가입 실패");
				url = "/jsp/duplicateUserInfo.jsp";
			}

			if(result == 0) {
				System.out.println("회원가입 실패 -- DB 저장할 떄 오류 발생");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return url;
	}

}
