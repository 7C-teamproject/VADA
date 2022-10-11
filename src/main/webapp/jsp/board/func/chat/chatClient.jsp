<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<jsp:include page="/jsp/top.jsp" />


<main>


		<script type="text/javascript" src="/Vada/js/ajax.js"></script>
		<script type="text/javascript" src="/Vada/js/chat.js"></script>
		<script type="text/javascript">
		window.onload = function() {
			var chatting = new chat.Chat();
		}
		</script>	


</main>
	
	
	
<jsp:include page="/jsp/bottom.jsp" />