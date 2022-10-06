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
	public List<Map> listBoard(String searchCate, String searchTextParam) 
			throws Exception {
		
		String prependSQL = VADAConstants.props.getProperty("LIST_SEARCH_SQL_PREPEND");
		String appendSQL = VADAConstants.props.getProperty("LIST_SEARCH_SQL_APPEND");
		String whereSQL = "";
		StringBuffer whereSQLBuffer = new StringBuffer();
		
		if (searchCate.equals("")) {
			whereSQLBuffer.append(" where 1=1 ");
			
		}
		else if (!searchTextParam.equals("") && searchTextParam!=null) {
			whereSQLBuffer.append(" where bcategorynum='");
			whereSQLBuffer.append(searchCate);
			whereSQLBuffer.append("' ");
			whereSQLBuffer.append("and ");
			whereSQLBuffer.append(" content like '%");
			whereSQLBuffer.append(searchTextParam);
			whereSQLBuffer.append("%' ");
		}
		
		whereSQL = whereSQLBuffer.toString();
		
		// ------------------------------------------------------------------------------------------------------
		
		String listSQL = VADAConstants.props.getProperty("LIST_SQL");
		
		Connection conn = getConnection();
		PreparedStatement pstmt 
		= conn.prepareStatement(listSQL);
		
		ResultSet rs = pstmt.executeQuery();

		Map<String,Object> map = new HashMap<String,Object>();
		
		List<Map> list2 = list2 = new ArrayList<Map>();
		
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
	
	
public List<NotifylistDTO> notifyListBoard() throws Exception{
		
		String sql = VADAConstants.props.getProperty("NOTIFY_LIST_SQL");
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List <NotifylistDTO> list = new ArrayList<NotifylistDTO>();
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


	@Override
	public int countAttachFiles(int bid) throws Exception {
		
		Connection conn = getConnection();
		
		// CallbleStatement 문법
		// 프로시져 : { call 프로시져명(?,?...) }
		// 함수 : { ? = call 함수명(?,?...) }
		// 데이터베이스 > 자바로 전달되는 변수는 out parameger로 등록 (registerOutParameter(인자번호, 디비타입))
		// 자바 > 데이터베이스로 전달되는 변수는 CallableStatement의 setter를 호출
		// execute()로 실행
		// 결과는 CallableStatement의 getter를 호출
		CallableStatement cstmt = conn.prepareCall("{ ? = call attachCount(?) }");
		cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
		cstmt.setInt(2, bid);
		cstmt.execute();
		int result = cstmt.getInt(1);
		
		closeConnection(cstmt, conn);
		return result;
		
	}

}
// class













