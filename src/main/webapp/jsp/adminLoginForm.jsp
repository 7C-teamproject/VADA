<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<link href="/Vada/css/login.css" rel="stylesheet" />

<script type="text/javascript">

	const loginText = document.querySelector(".title-text .login");
	const loginForm = document.querySelector("form.login");
	const loginBtn = document.querySelector("label.login");
	const signupBtn = document.querySelector("label.signup");
	const signupLink = document.querySelector("form .signup-link a");
	
	signupBtn.onclick = (()=>{
	  loginForm.style.marginLeft = "-50%";
	  loginText.style.marginLeft = "-50%";
	});
	
	loginBtn.onclick = (()=>{
	  loginForm.style.marginLeft = "0%";
	  loginText.style.marginLeft = "0%";
	});
	
	signupLink.onclick = (()=>{
	  signupBtn.click();
	  return false;
	});
	
</script>

<html>
	<head>
	</head>
	<body>
	<h1 style="color:red;">VADA</h1>
	<div class="wrapper">
      <div class="form-container">
         <div class="slide-controls">
            <label for="login" class="slide login">Admin Login</label>
         </div>
			<div class="form-inner">
			
			<form method="post" action="/Vada/adminloginproc.do" class="login">			<!-- 관리자 로그인창 데이터 폼 -->
					<div class="field">
						<input type="text" name="aduserid" placeholder="ID" required>		<!-- 관리자ID 데이터 입력 태그 -->
					</div>
					<div class="field">
						<input type="password" name="aduserpw" placeholder="Password" required>	<!-- 관리자PW 데이터 입력 태그 -->
					</div>
					<div class="field btn">
						<div class="btn-layer"></div>
						<input type="submit" value="Login">			<!-- 관리자 로그인 처리 핸들러로 데이터 전송 -->
					</div>
					<div class="signup-link">
                		<a href="/Vada/jsp/loginForm.jsp">로그인 화면으로 돌아가기</a>		<!-- 로그인 폼으로 돌아가기 -->
					</div>
			</form>
					
		    </div>
      </div>
   </div>
	
	</body>


</html>

