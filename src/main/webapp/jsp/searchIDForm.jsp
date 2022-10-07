<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%-- <jsp:include page="top.jsp" /> --%>

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
   width: 100%;
   margin-top: 20px;
}

.form-inner form .field input {
   height: 100%;
   width: 100%;
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
	<h1>VADA</h1>
	<div class="wrapper">
      <div class="form-container">
         <div class="slide-controls">
            <label for="searchid" class="slide login">Find ID</label>
         </div>
         
         <div class="form-inner">
         
            <form method="post" action="/Vada/searchidproc.do" class="searchid">
               <div class="field">
                  <input type="text" name="email_id" placeholder="email" required>
               </div>
               <div class="field">
                  <input type="text" name="username" placeholder="이름"
                     required>
               </div>
               <div class="pass-link">
                  <a href="/Vada/jsp/loginForm.jsp">로그인 화면으로 돌아가기</a>
               </div>
               <div class="field btn">
                  <div class="btn-layer"></div>
                  <input type="submit" value="아이디 찾기">
               </div>
                
            </form>

         </div>
      </div>
   </div>
	
	</body>


</html>


