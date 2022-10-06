package vada.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.SoldOutDAOImpl;
import vada.service.SoldOutService;

public class SoldOutProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String productnum = request.getParameter("productnum")==null? "" : request.getParameter("productnum");;
		String reserveid = request.getParameter("reserveid")==null? "" : request.getParameter("reserveid");
		
		SoldOutService soldOutService = new SoldOutDAOImpl();
		
		int result = 0;
		try {
			result = soldOutService.soldOut(reserveid , Integer.parseInt(productnum));
		} catch (Exception e) {
			e.printStackTrace();
		} // TODO 로그인 세션 구현 후 바꿔야함
		
		if (result != 0) {
			System.out.println("db결과 반영 성공");
		} else {
			System.out.println("실패");
		}
		
		return "boarddetailform.do";
	}

}
