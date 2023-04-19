<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<!-- /detail,do 경로로 boardNo=1, title=제목 파라미터로 보내기 -->
	
	<!-- 1. <a> -->
	<div>
		<a href="${contextPath}/detail.do?boardNo=1&title=제목">보내기</a>
		<a href="${contextPath}/detail.do">보내기(파라미터 없음)</a>
	</div>
	
	<!-- 2. <form> name이 파라미터-->
	<div>
		<form method="post" action="${contextPath}/detail.do">
			<input type="hidden" name="boardNo" value="1">
			<input type="hidden" name="title" value="제목">
			<button>보내기</button>
		</form>
		<form method="post" action="${contextPath}/detail.do">
			<button>보내기(파라미터 없음)</button>
		</form>
	</div>
	
	<!-- 3. location -->
	<div>
		<button onclick="fnMove()">보내기</button>
		<script>
			function fnMove(){
				location.href = '${contextPath}/detail.do?boardNo=1&title=제목';
			}
		</script>
	</div>




</body>
</html>