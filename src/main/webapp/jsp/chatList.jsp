<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="top.jsp" />

<main>

	<div class="container-fluid px-4">
		<h1 class="mt-4">채팅</h1>
		<ol class="breadcrumb mb-4">
		</ol>
		<div class="card mb-4">
			<div class="card-header">
				<i class="fas fa-table me-1"></i> 채팅목록
			</div>
			<div class="card-body">
			
				<table>
					<colgroup>
						<col width="3000px" />
						<col width="600px" />
					</colgroup>
					<thead>
						<tr>
							<th>닉네임(ID)</th>
							<th>시간</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>nick1(id1)</td>
							<td>date1</td>
						</tr>

						<tr>
							<td>nick2(id2)</td>
							<td>date2</td>
						</tr>
						<tr>
							<td>nick3(id3)</td>
							<td>date3</td>
						</tr>
					</tbody>
				</table>
				
			</div>
		</div>
	</div>

</main>

<jsp:include page="bottom.jsp" />