<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="top.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style>
* {
   margin: 0;
   padding: 0;
   box-sizing: border-box;
   font-family: 'Poppins', sans-serif;
}

html, body {
	display: grid;
	height: 100%; 
	width: 100%; 
	place-items: center;
}

::selection {
   background: #1a75ff;
   color: #fff;
}

.wrapper {
   overflow: hidden;
   width: 400px;
   background: #fff;
   padding: 30px;
   border-radius: 15px;
   box-shadow: 0px 15px 20px rgba(0, 0, 0, 0.1);
}

.wrapper .title-text {
   display: flex;
   width: 200%;
}

.wrapper .title {
   width: 100%;
   font-size: 35px;
   font-weight: 600;
   text-align: center;
   transition: all 0.6s cubic-bezier(0.68, -0.55, 0.265, 1.55);
}

input[type="radio"] {
   display: none;
}

#login:checked ~ label.signup {
   color: #000;
}

#login:checked ~ label.login {
   cursor: default;
   user-select: none;
}

.wrapper .form-container {
   width: 100%;
   overflow: hidden;
}

.form-container .form-inner {
   display: flex;
   width: 200%;
}

.form-container .form-inner form {
   width: 50%;
   transition: all 0.6s cubic-bezier(0.68, -0.55, 0.265, 1.55);
}

.form-inner form .field {
   height: 50px;
   width: auto;
   margin-top: 20px;
}

.form-inner form .field input {
   height: 100%;
   width: auto;
   outline: none;
   padding-left: 15px;
   border-radius: 15px;
   border: 1px solid lightgrey;
   border-bottom-width: 2px;
   font-size: 17px;
   transition: all 0.3s ease;
}

.form-inner form .field input:focus {
   border-color: #1a75ff;
   /* box-shadow: inset 0 0 3px #fb6aae; */
}

.form-inner form .field input::placeholder {
   color: #999;
   transition: all 0.3s ease;
}

form .field input:focus::placeholder {
   color: #1a75ff;
}

.form-inner form .pass-link {
   margin-top: 5px;
}

.form-inner form .signup-link {
   text-align: center;
   margin-top: 30px;
}

.form-inner form .pass-link a, .form-inner form .signup-link a {
   color: #1a75ff;
   text-decoration: none;
}

.form-inner form .pass-link a:hover, .form-inner form .signup-link a:hover
   {
   text-decoration: underline;
}
</style>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

	// 우편번호 API
	window.onload = function() {
		document.getElementById("address_kakao").addEventListener("click", function() { // 주소입력칸을 클릭하면
			new daum.Postcode({
				oncomplete : function(data) { // 선택 시 입력값 세팅
					document.getElementById("address").value = data.address; // 주소 넣기
					document.querySelector("input[name=detailaddress]").focus(); // 상세입력 포커싱
				}
			}).open();
		});
	}

	//이메일 옵션 선택후 주소 자동 완성
	function change_email() {
		var email_add = document.getElementById("email_add");
		var email_sel = document.getElementById("email_sel");

		//지금 골라진 옵션의 순서와 값 구하기
		var idx = email_sel.options.selectedIndex;
		var val = email_sel.options[idx].value;

		email_add.value = val;
	}

</script>

<html>
	<head>
	</head>
	<body>
<div class="wrapper">
      <div class="form-container">
         <div class="slide-controls">
            <label for="login" style="font-weight: bold; font-size: 25px;">회원 정보 수정</label>
         </div>
         
         <div class="form-inner">
	<form name="join_form" action="/Vada/userinfoupdateproc.do" method="post">
	
		<div>
			아이디 : ${userDTO.userid}
		</div>
		<div class="field">
			비밀번호 : <input type="password" name="userpw" id="pwd" placeholder="영문자+숫자+특수문자 조합" value="${userDTO.userpw}"/>
		</div>
		<div class="field">
			비밀번호 재확인 : <input type="password" name="pwd" id="repwd" value="${userDTO.userpw}">
		</div>
		<div class="field">
			이름 : <input type="text" name="name" id="uname" value="${userDTO.name}">
		</div><br />
			<p>전화번호 : (※ "-"없이 숫자만 입력)</p>
		<div class="field">
			<input type="tel" name="tel" id="mobile" value="${userDTO.tel}">		  
		</div>
		<div class="field">
			이메일 : <input type="text" name="email" id="email_id" value="${userDTO.email}">@ <br />
			<input type="text" name="email_add" id="email_add"> 
			<select name="email_sel" id="email_sel" onchange="change_email();">
				<option value="">직접입력</option>
				<option value="naver.com">naver</option>
				<option value="gmail.com">gmail</option>
				<option value="nate.com">nate</option>
			</select>
		</div><br /><br />
		<div class="field">
			기본주소 : <button type="button" id="address_kakao">우편번호 찾기</button><br />
			<input type="text" id="address" name="address"  value="${userDTO.address}" readonly>
		</div><br />
		<div class="field">
			상세주소 : <input type="text" name="detailaddress" id="addr2" value="${userDTO.detailaddress}">
		</div>
		<div class="field">
			닉네임 : <input type="text" name="nickname" id="nickname" value="${userDTO.nickname}">
		</div>
		<div>
			관심 카테고리 : 
			<select name="ca1" id="cate1" >
                <option value="1000" >전체</option>
                <c:forEach var="categoryDTO" items="${categoryDTOList}">
	           		<c:if test="${fn:contains(categoryDTO.categorynum, '00')}" >
						<option value="${categoryDTO.categorynum}">${categoryDTO.categoryname}</option>
					</c:if>
				</c:forEach>
			</select> &nbsp;&nbsp;
							
				<select name="interestcategorynum" id="interestcategorynum" >
                	<option value="1000" >전체</option>
				</select> &nbsp;&nbsp;
							
				<script src="http://code.jquery.com/jquery-latest.js"></script>
				<script>
					$(document).ready(function() {
						$("#cate1").change(function(){
										
							$('#interestcategorynum').children('option:not(:first)').remove();
									
							var categoryappend = $(this).val().substring(0, 2);
										
							<c:forEach var="item" items="${categoryDTOList}">
											
							var categorynum = "${item.categorynum}";
												
								if(categorynum.match("^"+categoryappend) && categorynum!=$(this).val()) {
									$('#interestcategorynum').append($('<option>', {
								        value: ${item.categorynum},
								        text : '${item.categoryname}'
								    }));
								}
	
							</c:forEach>
						});
					});
				</script>
			</lable>
		</div>
		<div class="signup-link">
			<button type="button" onclick="history.back();">이전페이지로</button>
			<button type="button" onclick="this.form.submit();">변경하기</button>
		</div>
		
		
        </form>
		</div>
	</div>
   </div>
</body>

<jsp:include page="bottom.jsp" />
