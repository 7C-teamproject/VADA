<%@page import="vada.dao.impl.LikeCheckDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="vada.dao.impl.LikeAddDAOImpl"%>
<%@page import="vada.service.LikeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<% 
   int productnum = Integer.parseInt(request.getParameter("productnum"));
   String userid = (String)session.getAttribute("userid");
   
   LikeService likeService = new LikeCheckDAOImpl();
   List list = likeService.likeCheck(userid);
   
   boolean add = true; //1
   
   for(Object a : list){
      if((int)a == productnum){
         add = false; //0
      }
   }
   
   if(add){
      int b = new LikeAddDAOImpl().likeAdd(userid,productnum);
   }
   
   response.sendRedirect("/Vada/jsp/likeListForm.jsp");
%>