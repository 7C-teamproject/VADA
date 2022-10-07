<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vada.dto.NoteMessageDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vada.dao.impl.NoteMessageDAOImpl"%>
    
<jsp:useBean id="NoteMessageDTO" class="vada.dto.NoteMessageDTO" />    
<jsp:setProperty name="NoteMessageDTO" property="*" />
    
<%
   NoteMessageDAOImpl noteMessageDAOImpl = new NoteMessageDAOImpl();
   ArrayList<NoteMessageDTO> list_message = new ArrayList<NoteMessageDTO>();
   
   if(NoteMessageDTO != null) {
      list_message = noteMessageDAOImpl.showboard((String)session.getAttribute("userid"));
   }
   
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <div>
      <div>
         <% if(NoteMessageDTO != null) {%>
            <li><%= session.getAttribute("userid") %> 님에게 온 메시지 입니다.</li>
         <%} else { %>
               <li>로그인을 하세요</li>
         <%} %>
      </div>
   
      <table>
         <tr>
            <th>번호</th>
            <th>보내는 사람</th>
            <th>받는 사람</th>
            <th>내용</th>
            <th>시간</th>
         </tr>
         
         <%for(int i =0; i<list_message.size(); i++){ %>
         <tr>
            <td> <%= i+1 %> </td>
            <td> <%= list_message.get(i).getNotefromuserid() %> </td>
            <td> <%= list_message.get(i).getNotetouserid() %> </td>
            <td> <%= list_message.get(i).getMessage() %> </td>
            <td> <%= list_message.get(i).getM_date() %> </td>
         </tr>
         <%} %>
         
      <table>
         <tr>
            <th>번호</th>
            <th>보내는 사람</th>
            <th>받는 사람</th>
            <th>내용</th>
            <th>시간</th>
         </tr>
         
         
             <%for(int i =0; i<list_message.size(); i++){ %>
         <tr>
            <td> <%= i+1 %> </td>
            <td> <%= list_message.get(i).getNotefromuserid() %> </td>
            <td> <%= list_message.get(i).getNotetouserid() %> </td>
            <td> <%= list_message.get(i).getMessage() %> </td>
            <td> <%= list_message.get(i).getM_date() %> </td>
         </tr>
         <%} %>
      
      </table>
   
   </div>


</body>
</html>