<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="top.jsp" />

<main>
	  <div>
      <div>
        
          <h2>${sessionScope.userid} 님에게 온 메시지 입니다.</h2>

      </div>
   
      <table>
         <tr>
            <th>번호</th>
            <th>보내는 사람</th>
            <th>받는 사람</th>
            <th>내용</th>
            <th>시간</th>
         </tr>
          <c:forEach var="item" items="${listmessage}" varStatus="status">
         <c:if test="${sessionScope.userid eq item.notefromuserid }" >
          <tr>
          		<td>${status.index}</td>
          		<td>${item.notefromuserid}</td>
          		<td>${item.notetouserid }</td>
          		<td>${item.message }</td>
          		<td>${item.m_date }</td>
             </tr>
            </c:if>
            </c:forEach>
     </table>
     
     <br /><br />
     <table>
         <tr>
            <th>번호</th>
            <th>보내는 사람</th>
            <th>받는 사람</th>
            <th>내용</th>
            <th>시간</th>
         </tr>
          <c:forEach var="item" items="${listmessage}" varStatus="status">
         <c:if test="${sessionScope.userid ne item.notefromuserid }" >
          <tr>
          		<td>${status.index}</td>
          		<td>${item.notefromuserid}</td>
          		<td>${item.notetouserid }</td>  
          		<td>${item.message }</td>
          		<td>${item.m_date }</td>
             </tr>
            </c:if>
            </c:forEach>
            
     </table>
   </div>
   <br /><br />
   <button type="button" class="btn btn-primary pull-right" onclick="location.href='/Vada/jsp/mainformindex.jsp'">메인으로 돌아가기</button>

	
</main>
<jsp:include page="bottom.jsp" />