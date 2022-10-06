package vada.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vada.dao.impl.LikeAddDAOImpl;
import vada.dao.impl.LikeCheckDAOImpl;
import vada.service.LikeService;

public class AddLikeProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		int productnum = Integer.parseInt(request.getParameter("productnum"));
		String userid = (String) session.getAttribute("userid");

		LikeService likeService = new LikeCheckDAOImpl();
		List list = null;

		try {
			list = likeService.likeCheck(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean add = true; // 1

		for (Object a : list) {
			if ((int) a == productnum) {
				add = false; // 0
			} 
		}

		if (add) {
			try {
				int b = new LikeAddDAOImpl().likeAdd(userid, productnum);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return "/likeListForm.do";
	}

}
