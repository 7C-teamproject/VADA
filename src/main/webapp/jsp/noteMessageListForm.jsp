<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="top.jsp" />

<main>
	  <div>
	      <div>
	        
	          <h2>${sessionScope.userid} 님의 쪽지함</h2>
	
	      </div>
	   	<hr>
	   	<p>내가 보낸 쪽지</p>
	   	<hr>
	      <table>
	         <tr>
	            <th>보내는 사람</th>
	            <th>받는 사람</th>
	            <th>내용</th>
	            <th>시간</th>
	         </tr>
	          <c:forEach var="item" items="${listmessage}" varStatus="status">
	         <c:if test="${sessionScope.userid eq item.notefromuserid }" >
	          <tr>
	          		<td>${item.notefromuserid}</td>
	          		<td>${item.notetouserid}</td>
	          		<td>${item.message}</td>
	          		<td>${item.m_date}</td>
	             </tr>
	            </c:if>
	            </c:forEach>
	     </table>
	     <hr>
	     <br /><br />
	     <hr>
	     <p>내가 받은 쪽지</p>
	     <hr>
	     <table>
	         <tr>
	            <th>보내는 사람</th>
	            <th>받는 사람</th>
	            <th>내용</th>
	            <th>시간</th>
	         </tr>
	         
		     <c:forEach var="item" items="${listmessage}" varStatus="status">
		         <c:if test="${sessionScope.userid eq item.notetouserid }" >
			          <tr>
			          		<td>${item.notefromuserid}</td>
			          		<td>${item.notetouserid }</td>  
			          		<td>${item.message }</td>
			          		<td>${item.m_date }</td>
			             </tr>
		          </c:if>
		     </c:forEach>
	            
	     </table>
	     <hr>
	     
		   <br /><br />
		   <button type="button" class="btn btn-primary pull-right" onclick="location.href='/Vada/jsp/mainformindex.jsp'">메인으로 돌아가기</button>
	     
	   </div>
	   
		
</main>
<jsp:include page="bottom.jsp" />