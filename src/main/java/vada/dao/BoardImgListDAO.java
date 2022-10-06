package vada.dao;

import java.util.List;

import vada.dto.ImgDTO;
import vada.service.BoardImgService;

public interface BoardImgListDAO extends BoardImgService {
	public List<ImgDTO> listBoardImg(int productnum) throws Exception;
}
