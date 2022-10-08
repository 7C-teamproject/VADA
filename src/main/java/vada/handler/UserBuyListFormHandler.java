package vada.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vada.dao.impl.BuyListDAOImpl;
import vada.service.BuyListSerive;

public class UserBuyListFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		BuyListSerive buyListService = new BuyListDAOImpl();

		List list = null;
		
		try {
			list = buyListService.buyList((String) session.getAttribute("userid"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("list", list);
		
		return "jsp/userBuyListForm.jsp";
		
	}

}
