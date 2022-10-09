<%@page import="vada.dto.NotifylistDTO"%>
<%@page import="vada.dao.impl.BoardDetailDAOImpl"%>
<%@page import="vada.service.BoardDetailService"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="vada.dao.impl.BoardListDAOImpl"%>
<%@page import="vada.service.BoardListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<jsp:include page="top.jsp" />

<style>
.container>img {
	width: 10%;
}

.swiper-container {
	height: 200px;
	width: 630px;
	position: relative;
	overflow: hidden;
	list-style: none;
	z-index: 1;
	padding-bottom: 30px;
}

.swiper-slide {
	text-align: center;
/* 	display: flex; /* 내용을 중앙정렬 하기위해 flex 사용 */ */
	align-items: center; /* 위아래 기준 중앙정렬 */
	justify-content: center; /* 좌우 기준 중앙정렬 */
	display: inline;
}

.swiper-slide img {
	max-width: 100%;
	height: auto;
 	display: block;
 	padding-left: 200px;
}
</style>

<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<main>
<div class="container">
        <table class="table table-stripped" style="text-align: center; boarder: 1px solid #dddddd">
            <thead>
            <tr>
               <th colspan="2" style="background-color: #eeeeee; text-align: center;">신고글 상세 페이지</th>
            </tr>
         </thead>
      </table>
   </div>
   <div style="margin-left: 30%">

		<div class="swiper-container">
			<div class="swiper-wrapper">
			
				<!-- 신고글ID에 해당하는 이미지리스트를 받아서 출력 -->
				<c:forEach var="item" items="${imglist}" varStatus="status">
					<div class="swiper-slide">
							<img src="../${item}">
					</div>
	           	</c:forEach>	
	           	
			</div>
			<div class="swiper-pagination"></div>
			<div class="swiper-button-next"></div>
			<div class="swiper-button-prev"></div>
		</div>

		<!-- 	이미지 슬라이드 스크립트 -->
		<script>
			new Swiper('.swiper-container', {
				loop: true,
				spaceBetween: 30,
		        pagination: {
		          el: ".swiper-pagination",
		          clickable: true,
		          type: 'fraction'
		        },
		        navigation: {
		          nextEl: ".swiper-button-next",
		          prevEl: ".swiper-button-prev",
		        },
		      });
		</script>
		
			<!-- 신고글상세정보 Handler에서 처리된 notifylistDTO를 출력 -->
			<div class="row">
				<div class="col-md-6">
					<h3>신고자ID : ${notifylistDTO.notifyuserid}</h3>
					<h3>신고내용</h3><textarea style="width: 100%">${notifylistDTO.notifyreason}</textarea><br />
					<h3>신고날짜 : ${notifylistDTO.notifydate}</h3>
					<h3>원본게시물 : <a href="/Vada/boarddetailform.do?productnum=${notifylistDTO.notifyproductnum}">
					${notifylistDTO.notifyproductnum}</a>
					</h3>
					<br />
					<p>
						<a href="/Vada/notifydeleteproc.do?notifyid=${notifylistDTO.notifyid}" class="btn btn-secondary">글 삭제</a> 
					</p>
				</div>
			</div>

		<a href="/Vada/adminmanagenotifyform.do" class="btn btn-secondary" >신고글 목록</a>
		
	</div>
	
</main>

<jsp:include page="bottom.jsp" />