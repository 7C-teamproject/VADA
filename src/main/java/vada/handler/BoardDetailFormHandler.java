package vada.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.BoardDetailDAOImpl;
import vada.dto.BoardDTO;
import vada.dto.CategoryDTO;
import vada.dto.ProductpriceDTO;
import vada.service.BoardDetailService;

public class BoardDetailFormHandler implements CommandHandler{
	
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		String productnum = (String) request.getParameter("productnum") == null ? "" : (String) request.getParameter("productnum");
		System.out.println("productnum ==============> " + productnum);

		ProductpriceDTO productpriceDTO = new ProductpriceDTO();
		BoardDTO boardDTO = new BoardDTO();
		CategoryDTO categoryDTO = new CategoryDTO();

		BoardDetailService boardDetailService = new BoardDetailDAOImpl();

		Map<String, Object> map = null;
		try {
			map = boardDetailService.getBoardList(Integer.parseInt(productnum));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("map ==============> " + map);

		boardDTO = (BoardDTO) map.get("boardDTO");

		productpriceDTO = (ProductpriceDTO) map.get("ProductpriceDTO");
		categoryDTO = (CategoryDTO) map.get("categoryDTO");

//		List imgsnameList = (List) map.get("imgsnameList");
		List imgDTOList = (List) map.get("imgDTOList");
		

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
		request.setAttribute("imgDTOList", imgDTOList); 
		request.setAttribute("sellerid", boardDTO.getSellerid());
		request.setAttribute("buyerid", boardDTO.getBuyerid());

		return "jsp/boardDetailForm.jsp";
		
	}

}
