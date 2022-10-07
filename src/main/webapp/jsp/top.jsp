<%@page import="vada.dto.CategoryDTO"%>
<%@page import="java.util.List"%>
<%@page import="vada.dao.impl.CategoryListDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="vada.service.CategoryService"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
 
<%
 	CategoryService categoryService = new CategoryListDAOImpl();
 	List<CategoryDTO> categoryDTOList = categoryService.listCategory();
 	pageContext.setAttribute("categoryDTOList", categoryDTOList);
 %>
 
<!DOCTYPE html>
<style>
select {
    padding:3px;
    margin: 0;
    -webkit-border-radius:4px;
    -moz-border-radius:4px;
    border-radius:4px;
    -webkit-box-shadow: 0 3px 0 #ccc, 0 -1px #fff inset;
    -moz-box-shadow: 0 3px 0 #ccc, 0 -1px #fff inset;
    box-shadow: 0 3px 0 #ccc, 0 -1px #fff inset;
    background: #f8f8f8;
    color:#888;
    border:none;
    outline:none;
    display: inline-block;
    -webkit-appearance:none;
    -moz-appearance:none;
    appearance:none;
    cursor:pointer;
}
label:after {
    content:'<>';
    font:11px "Consolas", monospace;
    color:#aaa;
    -webkit-transform:rotate(90deg);
    -moz-transform:rotate(90deg);
    -ms-transform:rotate(90deg);
    transform:rotate(90deg);
    right:8px; top:2px;
    padding:0 0 2px;
    border-bottom:1px solid #ddd;
    position:absolute;
    pointer-events:none;
}
label:before {
    content:'';
    right:6px; top:0px;
    width:20px; height:20px;
    background:#f8f8f8;
    position:absolute;
    pointer-events:none;
    display:block;
}
</style>
<html>
    <head>
   	 	<meta charset="UTF-8">
		<title>Insert title here</title>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="/Vada/css/style.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
         <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="mainform.do">중고바다</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
             
            
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0" 
            		action="/Vada/searchresultform.do" method="post">

                <div class="input-group" style="line-height: 20px">
                <p style="color: white; margin-top: 15px;">카테고리 :</p>&nbsp;&nbsp;
                		<lable style="margin-top: 12px">
              				<select name="categories1" id="categories1" onchange="changeSelect1();" >
                				<option value="1000" >전체</option>
                				<c:forEach var="categoryDTO" items="${categoryDTOList}">
	           						<c:if test="${fn:contains(categoryDTO.categorynum, '00')}" >
										<option value="${categoryDTO.categorynum}">${categoryDTO.categoryname}</option>
									</c:if>
								</c:forEach>
							</select> &nbsp;&nbsp;
							
							<select name="categories2" id="categories2" >
                				<option value="1000" >전체</option>
							</select> &nbsp;&nbsp;
							
							<script src="http://code.jquery.com/jquery-latest.js"></script>
							<script>
								$(document).ready(function() {
									$("#categories1").change(function(){
										
										$('#categories2').children('option:not(:first)').remove();
										
										var categoryappend = $(this).val().substring(0, 2);
										
										<c:forEach var="item" items="${categoryDTOList}">
											
										var categorynum = "${item.categorynum}";
												
											if(categorynum.match("^"+categoryappend) && categorynum!=$(this).val()) {
												$('#categories2').append($('<option>', {
											        value: ${item.categorynum},
											        text : '${item.categoryname}'
											    }));
											}
	
										</c:forEach>
									});
								});
							</script>
														
						</lable>
						
<!-- 				검색어 입력 텍스트 박스 -->
                    <input class="form-control" name="searchText" value="${selected}" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
<!--                검색 버튼(돋보기) -->
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button" onclick="this.form.submit()"><i class="fas fa-search"></i></button>
               </div>
            </form>
          
            <!-- Navbar-->
             <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                      <li class="nav-item dropdown">
                          <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                              <c:if test="${sessionScope.adminyn eq 'no'}" >
                                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="/Vada/likelistform.do">찜 목록</a></li>
                                       <li><a class="dropdown-item" href="/Vada/userbuylistform.do">구매 목록</a></li>
                                       <li><a class="dropdown-item" href="/Vada/userinfoupdateform.do">회원정보 번경</a></li>
                                     <li><hr class="dropdown-divider" /></li>
                                     <li><a class="dropdown-item" href="/Vada/logout.do">로그아웃</a></li>
                                </ul>
                          </c:if>
                          <c:if test="${sessionScope.adminyn eq 'yes'}" >
                                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="/Vada/adminmanageuserform.do">회원관리</a></li>
                                       <li><a class="dropdown-item" href="/Vada/adminmanagenotifyform.do">신고글 목록</a></li>
                                     <li><hr class="dropdown-divider" /></li>
                                     <li><a class="dropdown-item" href="/Vada/logout.do">로그아웃</a></li>
                                </ul>
                          </c:if>
                      </li>
                  </ul>   
            
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <a class="nav-link" href="/Vada/mainform.do">
                                <div class="sb-nav-link-icon"></div>
                                중고거래
                            </a>
                              <a class="nav-link" href="index.html">
                                <div class="sb-nav-link-icon"></div>
                                채팅
                            </a>
                            
                        </div>
                    </div>
                   
                </nav>
            </div>
            <div id="layoutSidenav_content">
            