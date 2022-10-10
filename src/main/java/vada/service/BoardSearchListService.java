package vada.service;

import java.util.List;
import java.util.Map;

public interface BoardSearchListService extends BoardService {

	public abstract List<Map> searchBoard(String level1Category, String level2Category, String searchText) throws Exception;

}
