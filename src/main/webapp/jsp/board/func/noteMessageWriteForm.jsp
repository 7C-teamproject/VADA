<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/jsp/top.jsp" />

<main>
	  <div>
	  
	  <!-- 메시지 작성을 위한 데이터 저장 폼 -->
      <form action="${webapproot}/MessageServlet" method="post">
         <input type="hidden" name="productnum" value="${param.productnum}" />
         <input type="hidden" name="sellerid" value="${param.sellerid}" />
         
         <div>
            <lable for="notefromuserid">받는 사람</lable>
            <input readonly="readonly" type="text" id="toid" name="notetouserid" value="${param.sellerid}"/> <!--  받는 사람 ID (판매자 ID) -->
         </div>
         
         <div>
            <input type="hidden" id="fromid" name="notefromid"/>	<!-- 보내는 사람 ID (유저 ID) -->
         </div>
         
         <div>
            <lable for="message">&nbsp;&nbsp;쪽지 내용</lable>
            <textarea id="message" rows="20" name="message"></textarea>
         </div>
         
         <ul class="actions">
            <li><input type="submit" value="쪽지 보내기" /></li>
            <li><input type="reset" value="내용지우기" /></li>
            <li><input type="button" value="이전페이지로" onclick="history.back();"/></li>
            
         </ul>
      </form>
   
   </div>

</main>
 
 <jsp:include page="/jsp/bottom.jsp" />
 