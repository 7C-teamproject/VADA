package vada.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vada.dao.impl.NoteMessageDAOImpl;
import vada.dto.NoteMessageDTO;

@WebServlet("/MessageServiceCon")
public class MessageServiceCon extends HttpServlet {

   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	   HttpSession session = req.getSession();
	   
      String notefromuserid = (String) session.getAttribute("userid");
      String notetouserid = "testid1";
      String message = req.getParameter("message");
         
      
      System.out.println(notefromuserid);
      System.out.println(notetouserid);
      System.out.println(message);
      
      NoteMessageDTO noteMessageDTO = new NoteMessageDTO(notefromuserid, notetouserid, message);
      NoteMessageDAOImpl noteMessageDAOImpl = new NoteMessageDAOImpl();
      
      int result = noteMessageDAOImpl.insertMessage(noteMessageDTO);
      
      if(result > 0) {
         System.out.println("메시지 전송 성공");
      } else {
         System.out.println("메시지 전송 실패");
      }
      
      resp.sendRedirect("/Vada/jsp/chatmain.jsp");
      
   }

}