package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vada.constants.VADAConstants;
import vada.dao.LikeAddDAO;
import vada.dto.BoardDTO;
import vada.dto.ImgDTO;
import vada.dto.ProductpriceDTO;

public class LikeListDAOImpl extends AbstractLikeDAO implements LikeAddDAO {

	@Override
	public List<Map> likeList(String userid) throws Exception {

		List<Integer> list = get_Productnum(userid);
		
		List<Map> list2 = new ArrayList<Map>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		for(int productnum:list) {
			Connection conn = getConnection();
			//select * from board b inner join img i on b.productnum=i.imgproductnum inner join productprice p on p.productpricenum=b.productnum where i.imgnum=1 and b.productnum=?
			String listSQL = VADAConstants.props.getProperty("SELECT_LIKE_LIST_SQL");

			PreparedStatement pstmt = conn.prepareStatement(listSQL);
			pstmt.setInt(1, productnum);
			ResultSet rs = pstmt.executeQuery();

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
				map2.put("wdate", boardDTO.getWdate());
				map2.put("productnum", boardDTO.getProductnum());
				map2.put("productprice", productPriceDTO.getProductprice());
				map2.put("imgsname", imgDTO.getImgsname());
				map2.put("imgproductnum", imgDTO.getImgproductnum());

				list2.add(map2);

			}
			closeConnection(rs, pstmt, conn);
		}
		
		System.out.println(list2);

		return list2;
	} // listBoard
	
	@Override
	public List<Integer> get_Productnum(String userid) throws Exception {
		
		Connection conn2 = getConnection();
		
		//select likeproductnum from likelist where likeuserid=?
		String getNum = VADAConstants.props.getProperty("SELECT_LIKE_PRODUCT_NUM_SQL");
		
		PreparedStatement pstmt2 = conn2.prepareStatement(getNum);
		
		pstmt2.setString(1, userid);
		
		ResultSet rs2 = pstmt2.executeQuery();
		
		List<Integer> list = new ArrayList<Integer>();
		
		while (rs2.next()){
			list.add(rs2.getInt("likeproductnum"));
		}
		
		closeConnection(rs2, pstmt2, conn2);
		
		return list;
		
	}
	
}
