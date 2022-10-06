package vada.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.BoardViewDAOImpl;
import vada.dto.NotifylistDTO;
import vada.service.BoardViewService;

public class NotifyDetailHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		
		  int notifyid = Integer.parseInt(request.getParameter("notifyid"));

		   BoardViewService notifyViewService = new BoardViewDAOImpl();
		   
		   Map<String, Object> map = null;
			try {
				map = notifyViewService.notifyView(notifyid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		   
		   NotifylistDTO notifylistDTO = new NotifylistDTO();
		   
		   notifylistDTO = (NotifylistDTO) map.get("notifylistDTO");
			List list = (List) map.get("imglist");
		   
		   request.setAttribute("notifylistDTO", notifylistDTO);
		   request.setAttribute("imglist", list);
		   
		   System.out.println("@@@@@@@@@@@@@@@@@List"+list);
		
		
		return "jsp/notifyDetail.jsp";
	}
	
}
