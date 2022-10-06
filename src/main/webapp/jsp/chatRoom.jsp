<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="top.jsp" />

<style>
# /public /css /style.css
----------
#roomWrap {
	width: 200px;
}

#roomList {
	border: 1px solid #0084FF;
	border-radius: 5px;
}

#roomHeader {
	background-color: #0084FF;
	color: #fff;
	height: 40px;
	font-size: 18px;
	line-height: 40px;
	text-align: center;
	border-radius: 5px;
}

.roomEl {
	text-align: center;
	border-bottom: 1px solid #f0f0f0;
	padding: 10px 0px;
	cursor: pointer;
}

.roomEl:hover {
	background: #f0f0f0;
}

.roomEl.active {
	background: #f0f0f0;
}

# /public /css /style.css
----------
#chatWrap {
	width: 600px;
	border: 1px solid #ddd;
}

#chatHeader {
	height: 60px;
	text-align: center;
	line-height: 60px;
	font-size: 25px;
	font-weight: 900;
	border-bottom: 1px solid #ddd;
}

#chatLog {
	height: 700px;
	overflow-y: auto;
	padding: 10px;
}

.myMsg {
	text-align: right;
}

.anotherMsg {
	text-align: left;
	margin-bottom: 5px;
}

.msg {
	display: inline-block;
	border-radius: 15px;
	padding: 7px 15px;
	margin-bottom: 10px;
	margin-top: 5px;
}

.anotherMsg>.msg {
	background-color: #f1f0f0;
}

.myMsg>.msg {
	background-color: #0084FF;
	color: #fff;
}

.anotherName {
	font-size: 12px;
	display: block;
}

#chatForm {
	display: block;
	width: 100%;
	height: 50px;
	border-top: 2px solid #f0f0f0;
}

#message {
	width: 85%;
	height: calc(100% - 1px);
	border: none;
	padding-bottom: 0;
}

#message:focus {
	outline: none;
}

#chatForm>input[type=submit] {
	outline: none;
	border: none;
	background: none;
	color: #0084FF;
	font-size: 17px;
}

# /public /css /style.css
----------
#memberWrap {
	width: 200px;
}

#memberList {
	border: 1px solid #aaaaaa;
	border-radius: 5px;
}

#memberHeader {
	height: 40px;
	font-size: 18px;
	line-height: 40px;
	padding-left: 15px;
	border-bottom: 1px solid #f0f0f0;
	font-weight: 600;
}

.memberEl {
	border-bottom: 1px solid #f0f0f0;
	padding: 10px 20px;
	font-size: 14px;
}

# /public /css /style.css
----------
#contentCover {
	width: 1280px;
	margin: 0 auto;
	padding-top: 20px;
	display: flex;
	justify-content: space-around;
}
</style>

<main>

	<div id="contentWrap">
		<nav></nav>
		<div id="contentCover">
			<div id="roomWrap">
				<div id="roomList"></div>
				<div id="chatWrap">
					<div id="chatHeader">Everyone</div>
					<div>
						<img class="fit-picture" src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA4MDJfMjUx%2FMDAxNjU5NDMxNzQxNTU0.W9USLppTWTK64u-7vi1_Z1cm2JARSSdBscfySacobGAg.Jbi3WLOAXJhFjvj0iMNDzGuDuI_MvGLYaQDtzAyo1Wgg.JPEG.edam-a%2F%25C0%25CC%25BA%25B4%25C7%25E5.JPG&type=a340" /><br />
						가격 : <input type="text" value="게시물 가격값" /><br /> 
						예약 여부 : <input type="text" value="예약 여부 Y/N" /><br /> 
						<input type="text" value="가격" /> 
						<input type="button" id="roomHeader" value="판매 예약/ 취소">
					</div>
					<div id="chatLog">
						<div class="anotherMsg">
							<span class="anotherName">Jo</span> 
							<span class="msg">Hello, Nice to meet you.</span>
						</div>
						<div class="myMsg">
							<span class="msg">Nice to meet you, too.</span>
						</div>
					</div>
					<form id="chatForm">
						<input type="text" autocomplete="off" size="30" id="message" placeholder="메시지를 입력하세요"> <input type="submit" value="보내기">
					</form>
				</div>
				<div id="memberWrap">
					<div id="memberList">
						<div id="memberHeader">사람</div>
						<div id="memberSelect"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>

<jsp:include page="bottom.jsp" />