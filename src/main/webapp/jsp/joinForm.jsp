<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="top.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!-- 우편번호 확인을 위한 API 시작 -->
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
<!-- 우편번호 확인을 위한 API 끝 -->

<main>

	<form name="join_form" action="/Vada/joinProc.do" method="post">
		<div>
			<label>아이디<input type="text" name="userid" id="uid"></label>
			<button type="button" onclick="id_check();">중복확인</button>
		</div>
		<div>
			<label>비밀번호<input type="password" name="pwd" id="pwd" placeholder="영문자+숫자+특수문자 조합"></label>
		</div>
		<div>
			<label>비밀번호 재확인<input type="password" name="userpw" id="repwd"></label>
		</div>
		<div>
			<label>이름<input type="text" name="name" id="uname"></label>
		</div>

		<div>
			<label>전화번호<input type="tel" name="tel" id="mobile"> ex "-"없이 숫자만 입력 </label>
		</div>
		<div>
			<label>이메일<input type="text" name="email" id="email_id">@</label> 
			<input type="text" name="email_add" id="email_add"> 
			<select name="email_sel" id="email_sel" onchange="change_email();">
				<option value="">직접입력</option>
				<option value="naver.com">naver</option>
				<option value="gmail.com">gmail</option>
				<option value="nate.com">nate</option>
			</select>
		</div>
		<div>
			<label>기본주소<input type="text" id="address" name="address" readonly></label>
			<button type="button" id="address_kakao">우편번호 찾기</button>
		</div>
		<div>
			<label>상세주소<input type="text" name="detailaddress" id="addr2" size="30"></label>
		</div>
		<div>
			<label>닉네임<input type="text" name="nickname" id="nickname"></label>
		</div>
		<div>
			<lable>관심 카테고리 
			
				<!-- 카테고리 리스트 출력 시작 -->
				<select name="ca1" id="cate1" >
                	<option value="all" >전체</option>
                	<c:forEach var="categoryDTO" items="${categoryDTOList}">
	           			<c:if test="${fn:contains(categoryDTO.categorynum, '00')}" >
							<option value="${categoryDTO.categorynum}">${categoryDTO.categoryname}</option>
						</c:if>
					</c:forEach>
				</select> &nbsp;&nbsp;
							
				<select name="bcategorynum" id="cate2" >
                	<option value="all" >전체</option>
				</select> &nbsp;&nbsp;
							
				<script src="http://code.jquery.com/jquery-latest.js"></script>
				<script>
					$(document).ready(function() {
						$("#cate1").change(function(){
										
							$('#cate2').children('option:not(:first)').remove();
									
							var categoryappend = $(this).val().substring(0, 2);
										
							<c:forEach var="item" items="${categoryDTOList}">
											
							var categorynum = "${item.categorynum}";
												
								if(categorynum.match("^"+categoryappend) && categorynum!=$(this).val()) {
									$('#cate2').append($('<option>', {
								        value: ${item.categorynum},
								        text : '${item.categoryname}'
								    }));
								}
	
							</c:forEach>
						});
					});
				</script>
				<!-- 카테고리 리스트 출력 끝 -->
				
			</lable>
		</div>
		<div class="join_btn">
			<button type="button" onclick="history.back();">이전페이지로</button>
			<button type="button" onclick="this.form.submit();">가입하기</button>
		</div>
	</form>

</main>

<jsp:include page="bottom.jsp" />
