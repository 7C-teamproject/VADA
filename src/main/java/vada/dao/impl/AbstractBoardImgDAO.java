package vada.dao.impl;

import java.util.List;

import vada.dto.ImgDTO;
import vada.dto.NotifyimgDTO;
import vada.service.BoardImgService;

public abstract class AbstractBoardImgDAO extends BoardDAOImpl implements BoardImgService {

	@Override
	public int deleteBoardImg(int imgproductnum) throws Exception {
		return 0;
	}

	@Override
	public List<ImgDTO> getBoardImgList(int productnum) throws Exception {
		return null;
	}

//	@Override
//	public int updateBoardImg(int userid, List<ImgDTO> imgDTOlist) throws Exception {
//		return 0;
//	}

	@Override
	public ImgDTO viewBoardImg(int imgnum) throws Exception {
		return null;
	}

	@Override
	public int writeBoardImg(int imgproductnum, ImgDTO boardImgDTO) throws Exception {
		return 0;
	}

	@Override
	public int notifyWriteBoardImg(int notifyid, NotifyimgDTO notifyImgDTO) throws Exception {
		return 0;
	}
	
}
