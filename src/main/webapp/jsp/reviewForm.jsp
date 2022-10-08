<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:useBean id="boardDTO" class="vada.dto.BoardDTO" />

<jsp:include page="top.jsp" />


<main>
	<div class="container">
		<div class="row">
			<form method="post"
				action="/Vada/reviewproc.do?productnum=${param.productnum}">

				<table class="table table-stripped"
					style="text-align: center; boarder: 1px solid #dddddd">

					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #eeeeee; text-align: center;">후기글 작성</th>
						</tr>
					</thead>

					<tbody>
						<tr>
							<td><textarea class="form-control" placeholder="후기글 내용"
									name="review" maxlength="2048" style="height: 350px"></textarea></td>
						</tr>
						<tr>
							<td>
								<p style="float: left; font-size: 20px">별점 :</p> <select
								name="reviewscore" style="float: right">
									<option value="1">★☆☆☆☆</option>
									<option value="2">★★☆☆☆</option>
									<option value="3">★★★☆☆</option>
									<option value="4">★★★★☆</option>
									<option value="5">★★★★★</option>
							</select>
							</td>
						</tr>
					</tbody>
				</table>
	<script src="/Vada/js/common.js"></script>
            <input type="submit" class="btn btn-primary pull-right" value="후기작성" onclick="javascript:confirmCommand('/Vada/reviewproc.do?productnum=${param.productnum}','후기작성');">
             <button type="button" class="btn btn-primary pull-right" onclick="history.back();">구매목록</button>
			</form>
		</div>
	</div>

</main>

<jsp:include page="bottom.jsp" />