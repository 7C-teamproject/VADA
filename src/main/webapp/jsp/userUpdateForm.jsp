<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="top.jsp" />

<main>

	<div>
		<label> 주소 : <input type="text" name="adress" size="20" /><br />
			상세주소 : <input type="text" name="dadress" size="15" /><br /> 
			이름 :<input type="text" name="name" size="15" /><br /> 
			닉네임 : <input type="text" name="nickname" size="15" /><br /> 
			아이디 : <input type="text" name="id" size="15" /><br /> 
			비밀번호 : <input type="password" name="pw1" size="15" /><br /> 
			비밀번호확인 : <input type="password" name="pw2" size="15" /><br /> 
			이메일 주소 : <input type="text" name="pw" size="15" /><br /> 
			전화번호 : <input type="text" name="phonenum" size="10" /><br />
			 
			관심 카테고리: <input type="text" name="category" size="10" />
			<select name="category1">
				<option value="select1">선택1</option>
				<option value="select2">선택2</option>
				<option value="select3">선택3</option>
				<option value="select4">선택4</option>
			</select>
			<select name="category2">
				<option value="select1">선택1</option>
				<option value="select2">선택2</option>
				<option value="select3">선택3</option>
				<option value="select4">선택4</option>
			</select><br />
			
			<button type="submit" value="회원가입">정보 변경</button>
			<button type="submit" value="취소">취소</button>
			
		</label>
	</div>


</main>

<jsp:include page="bottom.jsp" />