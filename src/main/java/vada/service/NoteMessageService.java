package vada.service;

import java.util.ArrayList;

import vada.dto.NoteMessageDTO;

public interface NoteMessageService extends BoardService {

	public abstract int insertMessage(NoteMessageDTO noteMessageDTO);

	public abstract ArrayList<NoteMessageDTO> showMessage();

}
