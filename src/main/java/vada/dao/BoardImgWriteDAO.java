package vada.dao;

import vada.dto.ImgDTO;
import vada.dto.NotifyimgDTO;
import vada.service.BoardImgService;

public interface BoardImgWriteDAO extends BoardImgService {
	public abstract int writeBoardImg(int imgproductnum, ImgDTO boardImgDTO) throws Exception;
	public int notifyWriteBoardImg(int notifyid, NotifyimgDTO notifyImgDTO) throws Exception; // 내꺼
}
