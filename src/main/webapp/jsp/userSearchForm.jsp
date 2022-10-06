<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="top.jsp" />

<main>

	<form>
		<b>1. 아이디 찾기</b>
		<p>이메일과 이름을 입력하세요.</p>
		<div class="inputBox">
			이메일 : <input type="email" name="email" placeholder="e-mail" maxlength="20">
		</div>
		<div class="inputBox">
			이름 : <input type="text" name="username" placeholder="name" maxlength="20">
		</div>
		<input type="submit" name="findID" value="아이디 찾기"> <input type="button" name="back" value="취소">
	</form>
	
	<form>
		<b>2. 비밀번호 찾기</b>
		<p>아이디와 이메일을 입력하세요.</p>
		<div class="inputBox">
			아이디 : <input type="text" name="userID" placeholder="name" maxlength="20">
		</div>
		<div class="inputBox">
			이메일 : <input type="email" name="email" placeholder="e-mail" maxlength="20">
		</div>
		<input type="submit" name="findID" value="아이디 찾기"> <input type="button" name="back" value="취소">
	</form>
	
</main>

<jsp:include page="bottom.jsp" />