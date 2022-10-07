<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%if(request.getParameter("productnum")==null) {%>
<script>
	location.href = "/Vada/mainform.do";
</script>
<%}%>

<%if(request.getParameter("productnum")!=null){
	response.sendRedirect("/Vada/boarddetailform.do?productnum="+request.getParameter("productnum"));
}%>