
<%@page import="vada.constants.VADAConstants"%>
<%@page import="vada.dto.ChatmsgDTO"%>
<%@page import="vada.dto.KtuserchatroomDTO"%>
<%@ page contentType = "text/xml; charset=utf-8" %>
<%@page import="java.util.List"%>
<%@page import="vada.util.Util"%>
<%@page import="vada.util.DB"%>
<%@page import="java.util.ArrayList"%>
<%@ page import = "java.sql.*" %>


<%
	int lastMsgId = Integer.parseInt(request.getParameter("lastMsgId"));
	List messageList = new ArrayList();
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	
	int newLastMsgId = 0;
	
	boolean isSuccess = true;
	
	try {
		conn = DB.getConnection();
		pstmt = conn.prepareStatement(VADAConstants.props.getProperty("SELECT_MAX_MSG_ID_SQL"));
		//SELECT_MAX_MSG_ID_SQL=      select max(chatmsgid) from chatmsg
		if (lastMsgId != 0) { // 이전 채팅 내용이 있으면 실행
// 			rs = stmt.executeQuery("select max(MESSAGE_ID) from CHAT_MESSAGE");

	
			 rs1=pstmt.executeQuery();
			if (rs1.next()) {
				newLastMsgId = rs1.getInt(1);
			}
			
			
		} else { // 최초 채팅 시 실행
// 			rs = stmt.executeQuery("select * from CHAT_MESSAGE "+
// 			    "where MESSAGE_ID > "+lastMsgId + " order by MESSAGE_ID asc");
			pstmt2=	conn.prepareStatement(VADAConstants.props.getProperty("SELECT_MSG_PRODUCTNUM"));			

			//SELECT_MSG__PRODUCTNUM=select *   from chatmsg where chatmsgproductnum = ? order by chatmsgdate asc
			
			ChatmsgDTO chatmsgDTO = new ChatmsgDTO();

			pstmt2.setInt(1, 7);
			rs2 = pstmt2.executeQuery();
			
			while(rs2.next()) {
				chatmsgDTO.setChatmsgproductnum(rs2.getInt("chatmsgproductnum"));
				messageList.add(rs2.getString("msg"));
				newLastMsgId = rs2.getInt("chatmsgid");
			}
		}
		
		
	} catch(SQLException ex) {
		isSuccess = false;
	} finally {
		if (rs2 != null) try { rs2.close(); } catch(SQLException ex) {}
		if (rs1 != null) try { rs1.close(); } catch(SQLException ex) {}
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
%>


<result> 
	<code><%= isSuccess ? "success" : "fail" %></code>
	<%	if (isSuccess) { %>
	<lastMsgId><%= newLastMsgId %></lastMsgId>
	<messages>
	<%		for (int i = 0 ; i < messageList.size() ; i++) { %>
		<message><![CDATA[<%= Util.toJS((String)messageList.get(i)) %>]]></message>
	<%		} %>
	</messages>
	<%	} %>
</result>