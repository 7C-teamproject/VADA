<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="top.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style>
select {
	-moz-appearance: none;
	-webkit-appearance: none;
	appearance: none;
	font-family: "Noto Sansf KR", sans-serif;
	font-size: 1rem;
	font-weight: 400;
	line-height: 1.5;
	color: #444;
	background-color: #fff;
	padding: .6em 1.4em .5em .8em;
	margin: 0;
	border: 1px solid #aaa;
	border-radius: .5em;
	box-shadow: 0 1px 0 1px rgba(0, 0, 0, .04);
}

select:hover {
	border-color: #888;
}

select:focus {
	border-color: #aaa;
	box-shadow: 0 0 1px 3px rgba(59, 153, 252, .7);
	box-shadow: 0 0 0 3px -moz-mac-focusring;
	color: #222;
	outline: none;
}

select:disabled {
	opacity: 0.5;
}

label {
	font-family: "Noto Sans KR", sans-serif;
	font-size: 1rem;
	font-weight: 600;
	line-height: 1.3;
	color: #444;
	margin-right: 0.5em;
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

<main>
<h5>회원 정보 수정</h5>
	<form name="join_form" action="/Vada/userinfoupdateproc.do" method="post">
		<div>
			<label>아이디<input type="text" name="userid" id="uid" value="${userDTO.userid}"></label>
			<button type="button" onclick="id_check();">중복확인</button>
		</div>
		<div>
			<label>비밀번호<input type="password" name="userpw" id="pwd" placeholder="영문자+숫자+특수문자 조합" value="${userDTO.userpw}"/></label>
		</div>
		<div>
			<label>비밀번호 재확인<input type="password" name="pwd" id="repwd" value="${userDTO.userpw}"></label>
		</div>
		<div>
			<label>이름<input type="text" name="name" id="uname" value="${userDTO.name}"></label>
		</div>

		<div>
			<label>전화번호<input type="tel" name="tel" id="mobile" value="${userDTO.tel}"> ex "-"없이 숫자만 입력 </label>
		</div>
		<div>
			<label>이메일<input type="text" name="email" id="email_id" value="${userDTO.email}">@</label> 
			<input type="text" name="email_add" id="email_add"> 
			<select name="email_sel" id="email_sel" onchange="change_email();">
				<option value="">직접입력</option>
				<option value="naver.com">naver</option>
				<option value="gmail.com">gmail</option>
				<option value="nate.com">nate</option>
			</select>
		</div>
		<div>
			<label>기본주소<input type="text" id="address" name="address"  value="${userDTO.address}"readonly></label>
			<button type="button" id="address_kakao">우편번호 찾기</button>
		</div>
		<div>
			<label>상세주소<input type="text" name="detailaddress" id="addr2" size="30" value="${userDTO.detailaddress}"></label>
		</div>
		<div>
			<label>닉네임<input type="text" name="nickname" id="nickname" value="${userDTO.nickname}"></label>
		</div>
		<div>
			<lable>관심 카테고리 
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
		<div class="join_btn">
			<button type="button" onclick="history.back();">이전페이지로</button>
			<button type="button" onclick="this.form.submit();">변경하기</button>
		</div>
	</form>

</main>

<jsp:include page="bottom.jsp" />
