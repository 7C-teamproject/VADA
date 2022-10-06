package vada.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vada.dao.impl.LikeListDeleteDAOImpl;

public class LikeListDeleteProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		 int productnum = Integer.parseInt((String) request.getParameter("productnum") == null ? "" : (String) request.getParameter("productnum"));

		   // 게시물 데이터 삭제
		   String userid = (String)session.getAttribute("userid");
		   try {
			new LikeListDeleteDAOImpl().likeDelete(userid, productnum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    
		return "/likelistform.do";
	}

}
