package vada.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.BoardViewDAOImpl;
import vada.dto.BoardDTO;
import vada.dto.CategoryDTO;
import vada.dto.ProductpriceDTO;
import vada.service.BoardViewService;

public class BoardDetailFormHandler implements CommandHandler{
	
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		String productnum = (String) request.getParameter("productnum");
		System.out.println("productnum ==============> " + productnum);

		ProductpriceDTO productpriceDTO = new ProductpriceDTO();
		BoardDTO boardDTO = new BoardDTO();
		CategoryDTO categoryDTO = new CategoryDTO();

		BoardViewService boardViewService = new BoardViewDAOImpl();

		Map<String, Object> map = null;
		try {
			map = boardViewService.viewBoard(Integer.parseInt(productnum));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("map ==============> " + map);

		boardDTO = (BoardDTO) map.get("boardDTO");

		productpriceDTO = (ProductpriceDTO) map.get("ProductpriceDTO");
		categoryDTO = (CategoryDTO) map.get("categoryDTO");

		List list1 = (List) map.get("imglist1");
		List list2 = (List) map.get("imglist2");
		List list3 = (List) map.get("imglist3");

		request.setAttribute("boardDTO", boardDTO);
		String reserveText = "판매중";
		if (!boardDTO.getBuyerid().equals("default")) {
			reserveText = "판매완료";
		} else {
			if (boardDTO.getReservation().equals("yes")) {
				reserveText = "판매예약";
			} else {
				reserveText = "판매중";
			}
		}
		request.setAttribute("reserveText", reserveText);

		request.setAttribute("productpriceDTO", productpriceDTO);

		request.setAttribute("categoryDTO", categoryDTO);

		request.setAttribute("imglist1", list1); 
		request.setAttribute("imglist2", list2); 
		request.setAttribute("imglist3", list3); 

		request.setAttribute("sellerid", boardDTO.getSellerid());
		request.setAttribute("buyerid", boardDTO.getBuyerid());

		System.out.println("boardDTO ===========================> " + boardDTO);

		request.setAttribute("productpriceDTO", productpriceDTO);
		System.out.println("productpriceDTO ===========================> " + productpriceDTO);

		request.setAttribute("categoryDTO", categoryDTO);
		System.out.println("categoryDTO ===========================> " + categoryDTO);

		request.setAttribute("reserveText", reserveText);
		
		return "jsp/boardDetailForm.jsp";
		
	}

}
