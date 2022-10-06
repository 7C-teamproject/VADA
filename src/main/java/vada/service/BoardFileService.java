package vada.service;

import java.util.List;

import vada.dto.ImgDTO;

public interface BoardFileService extends BoardService {

//	public abstract List<BoardFileDTO> listBoardFile(int bid) throws Exception;
//
//	public abstract BoardFileDTO viewBoardFile(int bfid) throws Exception;
//
//	public abstract int writeBoardFile(int bid, BoardFileDTO boardFileDTO) throws Exception;

	public abstract int deleteBoardFile(int bfid) throws Exception;
	
	public abstract int deleteBoardFiles(int bid) throws Exception;
	
//	public abstract int updateBoardFiles(int bid, List<BoardFileDTO> list) throws Exception;

}
