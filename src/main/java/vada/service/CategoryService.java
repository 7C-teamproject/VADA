package vada.service;

import java.util.List;

import vada.dto.CategoryDTO;

public interface CategoryService {

	public abstract List<CategoryDTO> listCategory() throws Exception;
}
