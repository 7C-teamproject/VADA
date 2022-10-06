<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
<%@ page import="java.util.Map"%>
<%@ page import="vada.service.BoardSearchListService"%>
<%@ page import="vada.dao.impl.BoardListDAOImpl"%>
<%@ page import="vada.service.BoardListService"%>
<%@ page import="vada.dao.impl.BoardSeachListDAOImpl"%>
<%@ page import="vada.dto.BoardDTO"%>
<%@ page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%

   String cate1 = request.getParameter("categories1") == null ? "" : request.getParameter("categories1");
   String cate2 = request.getParameter("categories2") == null ? "" : request.getParameter("categories2");
   String searchText = request.getParameter("searchText") == null ? "" : request.getParameter("searchText");
   
   List<Map> list = new BoardSeachListDAOImpl().listBoard(cate1, cate2, searchText);// 사용자가 입력한 검색어에 해당하는 결과를 가진 리스트

   pageContext.setAttribute("list", list);
   
%>

<jsp:include page="top.jsp" />

<style>
@charset "UTF-8";

@import url(//fonts.googleapis.com/earlyaccess/notosanskr.css);

html {
   font-family: "Noto Sans KR", sans-serif;
}

노말라이즈   
   body, ul, li {
   list-style: none;
   padding: 0;
   margin: 0;
}

a {
   text-decoration: none;
   color: inherit;
}

라이브러리   
   .con {
   margin-left: auto;
   margin-right: auto;
}

.cell {
   float: left;
   box-sizing: border-box;
   margin-bottom: 20px;
}

.row::after {
   content: "";
   display: block;
   clear: both;
}

.img-box>img {
   display: block;
   width: 100%;
   height: 300px;
}

커스텀   
   html, body {
   overflow-x: hidden;
}

.con {
   max-width: 1000px;
}

.logo-bar {
   text-align: center;
   margin-bottom: 20px;
   margin-top: 20px;
}

.bn-box {
   margin-bottom: 20px;
   margin-top: 20px;
}

@media ( max-width :700px ) {
   .top-bn-box-1 {
      overflow-x: hidden;
   }
   .top-bn-box-1>.img-box {
      margin-left: -50%;
   }
}

.menu-box {
   margin-bottom: 20px;
   margin-top: 20px;
}

.menu-box>ul>li {
   width: calc(100%/ 7);
}

@media ( max-width : 800px) {
   .menu-box {
      display: none;
   }
}

.menu-box>ul>li>a {
   display: block;
   text-align: center;
   font-weight: bold;
   position: relative;
}

.menu-box>ul>li:hover>a {
   color: red;
   text-decoration: underline;
}

.menu-box>ul>li>a::before, .menu-box>ul>li>a::after {
   content: "";
   width: 1px;
   height: 13px;
   background-color: black;
   position: absolute;
   top: 50%;
   transform: translatey(-50%);
   left: 0;
}

.menu-box>ul>li>a::after {
   left: auto;
   right: 0;
}

.menu-box>ul>li:first-child>a::before, .menu-box>ul>li:last-child>a::after
   {
   width: 2px;
}

.list>ul>li {
   width: calc(100%/ 3);
}

.list>ul>li {
   padding: 0 10px;
}

.list>ul {
   margin: 0 -10px;
}

.list>ul>li>.product-name {
   text-align: Center;
   font-weight: bold;
}

.list>ul>li:hover>.product-name {
   text-decoration: underline;
}

.list>ul>li>.product-price {
   text-align: center;
   font-weight: bold;
   font-size: 1.5rem;
}

.list>ul>li:hover>.product-date {
   text-align: Center;
}

@media ( max-width : 800px) {
   .list>ul>li {
      width: calc(100%/ 5);
   }
}

@media ( max-width : 650px) {
   .list>ul>li {
      width: calc(100%/ 4);
   }
}

@media ( max-width : 500px) {
   .list>ul>li {
      width: calc(100%/ 3);
   }
}

@media ( max-width : 400px) {
   .list>ul>li {
      width: calc(100%/ 2);
   }
}
</style>
<main>
      <div class="container">
        <table class="table table-stripped" style="text-align: center; boarder: 1px solid #dddddd">
            <thead>
            <tr>
               <th colspan="2" style="background-color: #eeeeee; text-align: center;">'${param.searchText}' 검색결과</th>
            </tr>
         </thead>
      </table>
   </div>

   <div style="margin-left: 23%" class="list con">
   
               
      <ul class="row" id="test">

         <c:set var="listSize" value="${list.size()}" />
         <c:if test="${fn:length(list) != 0}" >
         <c:forEach var="item" items="${list}" varStatus="stat">
            <li id="listid" class="cell">
               <div class="img-box">
               <img class=imgfile src="../${item.imgsname}" alt="">
               
               </div>
               <div id="productnum" class="product-name">${item.productnum}</div>
               
               <div class="product-price">
               <a href="/Vada/jsp/boardDetailForm.jsp?productnum=${item.productnum}">${item.title}</a>
               </div> <c:set var="sysYear">
                  <fmt:formatDate value="${item.wdate}"
                     pattern="yyyy-MM-dd hh:mm:ss" />
               </c:set>
               <div class="product-name">
                  <c:out value="${sysYear}" />
               </div>
            </li>

         </c:forEach>
         
         
         </c:if>
               <c:if test="${fn:length(list) == 0}" >
                    <h3 style="text-align: center;">'${param.searchText}' 검색결과 없음</h3>
               </c:if>
         

      </ul>

	<a href="/Vada/jsp/mainForm.jsp" class="btn btn-secondary" style="float:right;">메인화면으로 돌아가기</a>
   </div>

</main>

<jsp:include page="bottom.jsp" />