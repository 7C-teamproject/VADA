<?xml version="1.0" encoding="utf-8" ?>
<%@page import="vada.constants.VADAConstants"%>
<%@page import="java.net.Inet4Address"%>
<%@ page contentType = "text/xml; charset=utf-8" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.List" %>
<%@ page import = "vada.util.DB" %>
<%@ page import = "vada.util.Util" %>
<%

 	Timestamp timestamp=new Timestamp(System.currentTimeMillis());
	String nickName = request.getParameter("nickName");
	String userid = (String) session.getAttribute("userid");
	String msg = request.getParameter("msg");
	String message = Inet4Address.getLocalHost().getHostAddress()+timestamp+"["+userid+"] "+msg;
	Connection conn = null;
	System.out.println("dddddddddddddddddddddddddddd-------------------df-sdfdsfnsdkjfdskfsdf-sd-fsd-fsd-f-sd-f----------"+ request.getParameter("sellerid"));
	String sellerid= request.getParameter("sellerid");
	PreparedStatement pstmt = null;
	//int productnum=Integer.parseInt(request.getParameter("productnum"));
	boolean isSuccess = true;
	
	try {
		conn = DB.getConnection();
		
// 		pstmt = conn.prepareStatement(
// 			"insert into chatmsg (NICKNAME, REGISTER_DATE, MESSAGE) "+
// 			"values (?, now(), ?)");
// 		pstmt.setString(1, nickName);
// 		pstmt.setString(2, message);
		
		// insert into chatmsg  ( chatmsguserid, chatmsgproductnum,chatmsgsellerid,chatmsgdate,msg) values(?, ?, ?, now(), ? )
		
		String sql = VADAConstants.props.getProperty("INSERT_MSG_SQL");
		
		//INSERT_MSG_SQL=insert into chatmsg  ( chatmsguserid, chatmsgproductnum,chatmsgsellerid,chatmsgdate,msg) values(?, ?, ?, now(), ? )
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, userid);
		pstmt.setInt(2, 7);
		pstmt.setString(3, sellerid);
		pstmt.setString(4, message);
		
		
		int result = pstmt.executeUpdate();
		
		if(result >0) {
			System.out.println("채팅 메시지 DB에 저장 성공!!!!!!!!!!");
		} else {
			System.out.println("채팅 메시지 DB에 저장 실패!!!!!!!!!!");
		}
		
	} catch(SQLException ex) {
		isSuccess = false;
	} finally {
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
%>
<result>
	<code><%= isSuccess ? "success" : "fail" %></code>
</result>
