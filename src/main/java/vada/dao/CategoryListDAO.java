package vada.dao;

import java.util.List;

import vada.dto.CategoryDTO;
import vada.service.CategoryService;

public interface CategoryListDAO extends CategoryService {
	
	public abstract List<CategoryDTO> listCategory() throws Exception;

} 
