package vada.dao.impl.board.func;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vada.constants.VADAConstants;
import vada.dao.board.func.LikeAddDAO;
import vada.dto.BoardDTO;
import vada.dto.ImgDTO;
import vada.dto.LikelistDTO;
import vada.dto.ProductpriceDTO;

public class LikeListDAOImpl extends AbstractLikeDAO implements LikeAddDAO {

	@Override
	// 찜목록 리스트를 불러오기 위한 메소드
	public List<Map<String, Object>> likeList(String userid) throws Exception {
		
		// 현재 세션ID에 해당하는 제품 넘버리스트 획득
		List<Integer> likeProductNumList = get_Productnum(userid);

		// 찜목록 게시글에 필요한 정보들을 담은 Map타입 boardMap을 담기 위한 리스트 
		List<Map<String, Object>> likeList = new ArrayList<Map<String, Object>>(); 
		
		// BoardDTO, ImgDTO, ProductpriceDTO에서 필요한 데이터들만 얻기위한 Map타입 
		Map<String, Object> boardMap = null;
		
		// 찜목록의 제품 넘버 리스트에 해당하는 게시글 데이터들을 모두 얻기 위한 for 문
		for(int productnum:likeProductNumList) {
			
			Connection conn = getConnection();
			//select * from board b inner join img i on b.productnum=i.imgproductnum inner join productprice p on p.productpricenum=b.productnum where i.imgnum=1 and b.productnum=?
			String listSQL = VADAConstants.props.getProperty("SELECT_LIKE_LIST_SQL");

			PreparedStatement pstmt = conn.prepareStatement(listSQL);
			pstmt.setInt(1, productnum);
			ResultSet rs = pstmt.executeQuery();
			
			//select * from likelist l where likeuserid = l.likeuserid and likeproductnum =?
			String likeSQL = VADAConstants.props.getProperty("SELECT_LIKE_DATE_SQL");
			PreparedStatement pstmt2 = conn.prepareStatement(likeSQL);
			pstmt2.setInt(1, productnum);
			ResultSet rs2 = pstmt2.executeQuery();

			while (rs.next() & rs2.next()) {
				boardMap = new HashMap<String, Object>();
				
				LikelistDTO likelistDTO = new LikelistDTO();
				BoardDTO boardDTO = new BoardDTO();
				ImgDTO imgDTO = new ImgDTO();
				ProductpriceDTO productPriceDTO = new ProductpriceDTO();

				boardDTO.setTitle(rs.getString("title"));
				boardDTO.setWdate(rs.getTimestamp("wdate"));
				boardDTO.setProductnum(rs.getInt("productnum"));
				productPriceDTO.setProductprice(rs.getInt("productprice"));
				likelistDTO.setLikedate(rs2.getTimestamp("likedate"));

				imgDTO.setImgsname(rs.getString("imgsname"));
				imgDTO.setImgproductnum(rs.getInt("imgproductnum"));

				boardMap.put("title", boardDTO.getTitle());
				boardMap.put("wdate", boardDTO.getWdate());
				boardMap.put("productnum", boardDTO.getProductnum());
				boardMap.put("productprice", productPriceDTO.getProductprice());
				boardMap.put("imgsname", imgDTO.getImgsname());
				boardMap.put("imgproductnum", imgDTO.getImgproductnum());
				boardMap.put("likedate", likelistDTO.getLikedate());

				likeList.add(boardMap);

			}
			closeConnection(rs, pstmt, conn);
		}
		

		return likeList;
	} // listBoard
	
	@Override
	// LikeList를 불러오기 위해 현재 세션에 해당하는 제품넘버를 얻는 메소드	
	public List<Integer> get_Productnum(String userid) throws Exception {
	
		Connection conn2 = getConnection();
		
		//select likeproductnum from likelist where likeuserid=?
		String getNum = VADAConstants.props.getProperty("SELECT_LIKE_PRODUCT_NUM_SQL");
		
		PreparedStatement pstmt2 = conn2.prepareStatement(getNum);
		
		pstmt2.setString(1, userid);
		
		ResultSet rs2 = pstmt2.executeQuery();
		
		List<Integer> likeProductNumList = new ArrayList<Integer>();
		
		while (rs2.next()){
			likeProductNumList.add(rs2.getInt("likeproductnum"));
		}
		
		closeConnection(rs2, pstmt2, conn2);
		
		return likeProductNumList;
		
	}
	
}
