package vada.service;

import vada.dto.KtuserchatroomDTO;

public interface ChatService extends BoardService {

	public KtuserchatroomDTO ktchatroom(int  ktproductnum)throws Exception;
	
	public int chatBoard1(int productnum, 	KtuserchatroomDTO ktuserchatroomDTO) throws Exception;
	
}
