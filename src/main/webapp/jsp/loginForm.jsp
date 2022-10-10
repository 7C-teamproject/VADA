<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<link href="/Vada/css/login.css" rel="stylesheet" />

<!-- 로그인 폼 -->
<html>
	<head>
	</head>
	<body>
	<h1>VADA</h1>
	<div class="wrapper">
      <div class="form-container">
         <div class="slide-controls">
            <label for="login" class="slide login">Login</label>
         </div>
         
         <div class="form-inner">
         
            <form method="post" action="/Vada/loginproc.do" class="login">
               <div class="field">
                  <input type="text" name="userid" placeholder="ID" required>
               </div>
               <div class="field">
                  <input type="password" name="userpw" placeholder="Password"
                     required>
               </div>
               <div class="pass-link">
                  <a href="/Vada/jsp/adminLoginForm.jsp">관리자용 로그인</a>
               </div>
               <div class="pass-link">
                  <a href="/Vada/jsp/searchIDForm.jsp">아이디 찾기</a>
               </div>
                <div class="pass-link">
                  <a href="/Vada/jsp/searchPWForm.jsp">비밀번호 찾기</a>
               </div>
               <div class="field btn">
                  <div class="btn-layer"></div>
                  <input type="submit" value="Login">
               </div>
               <div class="signup-link">
                  <a href="/Vada/joinform.do">회원가입 하기</a>
               </div>
            </form>

         </div>
      </div>
   </div>
	
	</body>


</html>

