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
		userDTO.setInterestcategorynum(Integer.parseInt(request.getParameter("bcategorynum")));
		userDTO.setNickname("nickname");
		userDTO.setTel("tel");
		userDTO.setUserpw("userpw");
		userDTO.setUserid(request.getParameter("userid"));
		userDTO.setName(request.getParameter("name"));

		System.out.println(userDTO);

		boolean checkuserid = false;
		try {
			checkuserid = joinService.checkUserid(userDTO.getUserid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean checknickname = false;
		try {
			checknickname = joinService.checkUserid(userDTO.getNickname());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
		// 비밀번호 영문자+숫자+특수조합(8~25자리 입력) 정규식
		String pwdCheck = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{4,15}$";
		String telCheck = "^[0-9]*$";

		PrintWriter script;
		try {
			script = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (userDTO.getUserid() == null || userDTO.getUserpw() == null || userDTO.getName() == null
				|| userDTO.getTel() == null || userDTO.getEmail() == null || userDTO.getAddress() == null
				|| userDTO.getDetailaddress() == null || userDTO.getNickname() == null) {
//			script.println("<script>");
//			script.println("alert('입력이 안 된 사항이 있습니다.')");
//			script.println("history.back()");
//			script.println("</script>");
		} else if (!Pattern.matches(pwdCheck, userDTO.getUserpw())) {
//			script.println("<script>");
//			script.println("alert('비밀번호는 영문자+숫자+특수문자 조합으로 4~15자리 사용해야 합니다.')");
//			script.println("history.back()");
//			script.println("</script>");
		} else if (!request.getParameter("pwd").equals(userDTO.getUserpw())) {
//			script.println("<script>");
//			script.println("alert('비밀번호가 일치하지 않습니다.')");
//			script.println("history.back()");
//			script.println("</script>");
		} else if (!Pattern.matches(telCheck, userDTO.getTel())) {
//			script.println("<script>");
//			script.println("alert('전화번호는 숫자만 입력할 수 있습니다.')");
//			script.println("history.back()");
//			script.println("</script>");
		} else if (checkuserid == false) {
//			script.println("<script>");
//			System.out.println("userid=========>" + userDTO.getUserid());
//			script.println("alert('이미 존재하는 아이디입니다.')");
//			script.println("history.back()");
//			script.println("</script>");
		} else if (checknickname == false) {
//			script.println("<script>");
//			System.out.println("userid=========>" + userDTO.getUserid());
//			script.println("alert('이미 존재하는 닉네임입니다.')");
//			script.println("history.back()");
//			script.println("</script>");
		} else {
			try {
				int result = joinService.join(userDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			script.println("<script>");
//			script.println("location.href = '/Vada/jsp/mainForm.jsp'");
//			script.println("</script>");
		}

		return "/mainform.do";
	}

}
