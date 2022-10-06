package vada.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vada.dao.impl.LikeListDAOImpl;
import vada.service.LikeService;

public class LikeListFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		HttpSession session = request.getSession();
		
		   String userid= (String)session.getAttribute("userid");   
		   // 게시글 출력
		   LikeService likeService = new LikeListDAOImpl();
		   
		   List<Map> list = likeService.likeList(userid);
		   
		   request.setAttribute("list", list);
		
		
		
		
		return "jsp/likeListForm.jsp";
	}

}
