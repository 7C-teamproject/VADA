package vada.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.SearchUserPWDAOImpl;
import vada.service.SearchUserPWService;

public class SearchPWProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		  String userid = request.getParameter("userid");
		    String email = request.getParameter("email");
		    
		    SearchUserPWService searchUserPWService = new SearchUserPWDAOImpl();
		    
		    String userpw = null;
			try {
				userpw = searchUserPWService.searchUserPW(userid, email);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		    
			   
			PrintWriter script;
			try {
				script = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		       if(userpw == null){
		    	  
//		    	   script.println("<script>");
//			   		script.println("alert('일치하는 회원이 존재하지 않습니다.')");
//			   		script.println("history.back()");
//			   		script.println("</script>");
		    	   
		       }else{
		    	   
//		    	   script.println("<script>");
//			   		script.println("alert('회원님의 비밀번호는 "+userpw+" 입니다.')");
//			   		script.println("location.href='/Vada/jsp/loginForm.jsp'");
//			   		script.println("</script>");
		       }
		    
		return "/loginform.do";
	}

}
