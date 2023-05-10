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
<title>Insert title here</title>
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
</head>
<body>

	<div>
		<h1>${upload.uploadNo}번 UPLOAD 게시글 수정하기</h1>
	</div>
	
	<hr>
	<div>
		<form method="post" action="${contextPath}/upload/modiify.do">
			<div>
				<label for="title">제목</label>
				<input type="text" id="title" name="title" value="${upload.uploadTitle}">
			</div>
			<div>
				<div><label for="content">내용</label></div>
				<textarea id="content" name="content">${upload.uploadContent}</textarea>
			</div>
			<div>
				<label for="files">첨부</label>
				<input type="file" id="files" name="files" multiple="multiple" onchange="fnFileCheck(this)">
				<div id="fileList">첨부 파일의 목록이 이 곳에 표시됩니다</div>
			</div>
			<div>
				<input type="hidden" name="uploadNo" value="${upload.uploadNo}">
				<button>수정완료</button>
			</div>		
		</form>
	</div>
	
	
</body>
</html>