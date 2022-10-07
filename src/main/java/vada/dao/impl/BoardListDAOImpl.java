package vada.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vada.constants.VADAConstants;
import vada.dao.BoardListDAO;
import vada.dto.BoardDTO;
import vada.dto.CategoryDTO;
import vada.dto.ImgDTO;
import vada.dto.NotifylistDTO;
import vada.dto.ProductpriceDTO;

public class BoardListDAOImpl extends BoardDAOImpl implements BoardListDAO {

	@Override
	public List<Map> listBoard() throws Exception {

		String listSQL = VADAConstants.props.getProperty("LIST_SQL");

		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(listSQL);

		ResultSet rs = pstmt.executeQuery();

		Map<String, Object> map = new HashMap<String, Object>();

		List<Map> list2 = new ArrayList<Map>();

		while (rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
			ImgDTO imgDTO = new ImgDTO();
			ProductpriceDTO productPriceDTO = new ProductpriceDTO();

			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setWdate(rs.getTimestamp("wdate"));
			boardDTO.setProductnum(rs.getInt("productnum"));
			productPriceDTO.setProductprice(rs.getInt("productprice"));

			imgDTO.setImgsname(rs.getString("imgsname"));
			imgDTO.setImgproductnum(rs.getInt("imgproductnum"));

			Map<String, Object> map2 = new HashMap<String, Object>();

			map2.put("title", boardDTO.getTitle());
			map2.put("productnum", boardDTO.getProductnum());
			map2.put("wdate", boardDTO.getWdate());
			map2.put("productprice", productPriceDTO.getProductprice());
			map2.put("imgsname", imgDTO.getImgsname());
			map2.put("imgproductnum", imgDTO.getImgproductnum());

			list2.add(map2);

		}
		System.out.println(list2);
		closeConnection(rs, pstmt, conn);

		return list2;
	} // listBoard

	public List<NotifylistDTO> notifyListBoard() throws Exception {

		String sql = VADAConstants.props.getProperty("NOTIFY_LIST_SQL");
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<NotifylistDTO> list = new ArrayList<NotifylistDTO>();
		while (rs.next()) {
			NotifylistDTO notifyListDTO = new NotifylistDTO();
			notifyListDTO.setNotifyid(rs.getInt("notifyid"));
			notifyListDTO.setNotifyreason(rs.getString("notifyreason"));
			notifyListDTO.setNotifyuserid(rs.getString("notifyuserid"));
			notifyListDTO.setNotifydate(rs.getTimestamp("notifydate"));
			list.add(notifyListDTO);
		}
		closeConnection(rs, pstmt, conn);
		return list;
	}

}
// class
