package vada.dao;

import java.util.List;

import vada.dto.KtuserchatroomDTO;
import vada.service.ChatService;

public interface ChatDAO extends ChatService {
	
	public int ktchatBoard(int productnum, 	KtuserchatroomDTO ktuserchatroomDTO) throws Exception;
	
	public List<KtuserchatroomDTO> ktchatroomList(int productnum) throws Exception;
}
