package vada.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.JoinDAOImpl;
import vada.dto.UserDTO;
import vada.service.JoinService;

// 회원가입 처리를 위한 핸들러
public class JoinProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		JoinService joinService = new JoinDAOImpl();

		// userDTO 객체에 데이터 저장
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
			// 중복 아이디 검사
			checkUserID = joinService.checkUserid(userDTO.getUserid());

			// 중복 닉네임 검사
			checkNickName = joinService.checkUserid(userDTO.getNickname());
			
			// 중복된 ID와 닉네임이 없다면
			if (checkUserID == true && checkNickName == true) {
				// 회원 가입 처리
				result = joinService.join(userDTO);
				url = "/jsp/loginForm.jsp";
			} else if (checkUserID == false) {
				url = "/jsp/duplicateUserInfo.jsp";
			} else if (checkNickName == false) {
				url = "/jsp/duplicateUserInfo.jsp";
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return url;
	} // process

} // JoinProcHandler
