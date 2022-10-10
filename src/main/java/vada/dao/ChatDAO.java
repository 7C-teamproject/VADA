package vada.dao;

import java.util.List;

import vada.dto.KtuserchatroomDTO;
import vada.service.ChatService;

public interface ChatDAO extends ChatService {
	
	public abstract int ktchatBoard(int productnum, 	KtuserchatroomDTO ktuserchatroomDTO) throws Exception;
	
	public abstract List<KtuserchatroomDTO> ktchatroomList(String ktuserid) throws Exception;
}
