package vada.service;

import java.util.List;

import vada.dto.KtuserchatroomDTO;

public interface ChatService extends BoardService {

	public int ktchatBoard(int productnum, KtuserchatroomDTO ktuserchatroomDTO) throws Exception;

	public List<KtuserchatroomDTO> ktchatroomList(String ktuserid) throws Exception;
}
