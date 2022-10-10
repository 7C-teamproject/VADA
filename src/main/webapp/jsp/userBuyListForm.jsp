<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="top.jsp" />
 
<link href="/Vada/css/table.css" rel="stylesheet" />

<main>

	<div class="container-fluid px-4">
		<h1 class="mt-4">구매 목록</h1>
		<ol class="breadcrumb mb-4">
		</ol>
		<div class="card mb-4">
			<div class="card-header">
				<i class="fas fa-table me-1"></i> Buy List
			</div>
			<div class="card-body">
				<table>
					<colgroup>
						<col width="50%" />
						<col width="20%" />
						<col width="30%" />
					</colgroup>
					<thead>
						<tr>
							<th>게시물 제목</th>
							<th>구매일자</th>
							<th>후기작성</th>
						</tr>
					</thead>
					<tbody>
					
						<!-- 현재 사용자(세션ID)에 해당하는 구매목록 리스트 / buyerid가 사용자 ID와 같을 게시글 정보만 출력 -->
						<c:forEach var="boardDTO" items="${list}" varStatus="stat">
							<tr>
								<td>${boardDTO.title}</td>
								<td>${boardDTO.soldoutdate}</td>
								<td>
									<script src="/Vada/js/common.js"></script>
									
									<!-- 리뷰를 작성하지 않았다면 후기작성 버튼 출력O -->
									<c:if test="${boardDTO.review eq null}">
										<a class="btn btn-secondary"  style="float: right;"
											href="javascript:confirmCommand('/Vada/reviewform.do?productnum=${boardDTO.productnum}','후기작성');">후기작성</a>									
									</c:if>
									
									<!-- 리뷰를 작성했다면 후기작성 버튼 출력X -->
									<c:if test="${boardDTO.review ne null}">
										<a class="btn btn-secondary"  style="float: right;"
											href="javascript:confirmCommand('/Vada/boarddetailform.do?productnum=${boardDTO.productnum}','해당 게시글로 이동');">작성한 후기 보러가기</a>									
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<a href="/Vada/mainform.do" class="btn btn-secondary" style="float:right;">메인화면으로 돌아가기</a>
	</div>

</main>

<jsp:include page="bottom.jsp" />