package vada.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vada.constants.VADAConstants;
import vada.dao.CategoryListDAO;
import vada.dto.CategoryDTO;

public class CategoryListDAOImpl extends BoardDAOImpl implements CategoryListDAO  {

	@Override
	public List<CategoryDTO> listCategory() throws Exception {
		
		Connection conn = getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(VADAConstants.props.getProperty("CATEGORY_LIST_SQL"));

		ResultSet rs = pstmt.executeQuery(); // select ~~ 실행하는 문장 select 된 결과들이 rs에 저장됨
		
		List<CategoryDTO> categoryDTOList = new ArrayList<CategoryDTO>();
		
		while (rs!=null && rs.next()) { // 카테고리 여러 개 꺼내기 위해서 while 반복문으로 꺼냄
			CategoryDTO categoyDTO = new CategoryDTO();
			categoyDTO.setCategorynum(rs.getInt("categorynum"));
			categoyDTO.setCategoryname(rs.getString("categoryname"));
			categoryDTOList.add(categoyDTO);
		}
		
		System.out.println(categoryDTOList);
		
		closeConnection(rs, pstmt, conn);
		return categoryDTOList;
	}
	
}
