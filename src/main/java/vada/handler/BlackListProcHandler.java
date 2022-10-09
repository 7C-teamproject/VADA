package vada.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.ManagerDAOImpl;
import vada.service.ManagerService;

public class BlackListProcHandler implements CommandHandler {

	public String process(HttpServletRequest request, HttpServletResponse response) {

		int listsize = Integer.parseInt(request.getParameter("listsize"));
		System.out.println("listsize====>" + listsize);

		for (int i = 0; i < listsize; i++) {
			String buyerid = (String) request.getParameter(String.valueOf(i))==null?"":(String) request.getParameter(String.valueOf(i)); 
			String blackyn = (String) request.getParameter("blackyn" + String.valueOf(i))==null?"":(String) request.getParameter("blackyn" + String.valueOf(i)); 

			ManagerService managerService = new ManagerDAOImpl();
			int result = 0;
			try {
				result = managerService.blackList(buyerid, blackyn);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (result != 0) {
				System.out.println("블랙리스트 여부 디비에 저장 성공!!!!!!!!!");
			} else {
				System.out.println("블랙리스트 여부 디비에 저장 실패!!!!!!!!!");
			}
			System.out.println("buyerid====>" + buyerid + "  blackyn====>" + blackyn);
		}

		return "/adminmanageuserform.do";

	}
}
