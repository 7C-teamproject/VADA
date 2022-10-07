package vada.service;

import java.util.ArrayList;

import vada.dto.NoteMessageDTO;

public interface NoteMessageService extends BoardService {
	
public int insertMessage(NoteMessageDTO noteMessageDTO);
	
	public ArrayList<NoteMessageDTO> showboard(String notetouserid);

}
