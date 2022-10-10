package vada.dao;

import java.util.ArrayList;

import vada.dto.NoteMessageDTO;
import vada.service.NoteMessageService;

public interface NoteMessageDAO extends NoteMessageService{
	
	public abstract int insertMessage(NoteMessageDTO noteMessageDTO);
	
	public abstract ArrayList<NoteMessageDTO> showboard(String notetouserid);

}
