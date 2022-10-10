package vada.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vada.dao.impl.NoteMessageDAOImpl;
import vada.dto.NoteMessageDTO;

public class NoteMessageListFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		NoteMessageDAOImpl noteMessageDAOImpl = new NoteMessageDAOImpl();
		List<NoteMessageDTO> listmessage = new ArrayList<NoteMessageDTO>();

		NoteMessageDTO noteMessageDTO = new NoteMessageDTO();
		
		listmessage = noteMessageDAOImpl.showMessage();		
		
		request.setAttribute("listmessage", listmessage);
		
		return "/jsp/noteMessageListForm.jsp";
		
	}

}
