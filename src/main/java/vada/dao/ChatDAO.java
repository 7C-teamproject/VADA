package vada.dao;

import vada.dto.KtuserchatroomDTO;
import vada.service.ChatService;

public interface ChatDAO extends ChatService {
	public KtuserchatroomDTO ktchatroom(int  ktproductnum)throws Exception;
	
	public int chatBoard1(int productnum, 	KtuserchatroomDTO ktuserchatroomDTO) throws Exception;
}
