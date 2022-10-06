package vada.service;

import java.util.List;

import vada.dto.ImgDTO;
import vada.dto.NotifyimgDTO;

public interface BoardImgService extends BoardService {	
	
	public abstract List<ImgDTO> listBoardImg(int productnum) throws Exception;

	public abstract ImgDTO viewBoardImg(int imgnum) throws Exception;

	public abstract int writeBoardImg(int imgproductnum, ImgDTO boardImgDTO) throws Exception;

	public abstract int deleteBoardImg(int imgnum) throws Exception;
	
	public abstract int deleteBoardImgs(int userid) throws Exception;
	
	public abstract int updateBoardImg(int userid, List<ImgDTO> list) throws Exception;
	
	public int notifyWriteBoardImg(int notifyid, NotifyimgDTO notifyImgDTO) throws Exception;	// TODO 내꺼

}
