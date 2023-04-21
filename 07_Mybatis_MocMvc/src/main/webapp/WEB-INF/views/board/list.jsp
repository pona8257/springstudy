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
<script src="${contextPath}/resources/summernote-0.8.18-dist/summernote-lite.min.js"></script>
<script src="${contextPath}/resources/summernote-0.8.18-dist/lang/summernote-ko-KR.min.js"></script>
<link rel="stylesheet" href="${contextPath}/resources/summernote-0.8.18-dist/summernote-lite.min.css">
<title>Insert title here</title>
<style>
	tbody tr:hover {
		background-color: beige;
		cursor: pointer;
	}
	
</style>
<script>
	function fnDetail(n){
		location.href = '${contextPath}/board/detail.do?boardNo=' + n;
	}
	/* 
		''안에 넣은 이유는 addResult값이 안넘어 왔을때 빈 문자열로 보내기 위해서 (안그럼 안 넘와왔을떄 오류남)
		let addResult = '1';     삽입 성공
		let addResult = '0';	 삽입 실패
		let addResult = '';      삽입과 상관 없음
	
	*/
	$(function(){
		let addResult = '${addResult}';
		if(addResult != ''){
			if(addResult == '1'){
				alert('게시글이 등록되었습니다.');
			} else{
				alert('게시글 등록이 실패했습니다.');
			}
		}
		let removeResult = '${removeResult}';
		if(removeResult != ''){
			if(removeResult == '1'){
				alert('게시글이 삭제되었습니다.');
			} else{
				alert('게시글이 삭제되지 않았습니다.');	
			}
		}
		
	})
</script>
</head>
<body>
	
	<div>
		<a href="${contextPath}/board/write.do">게시글작성하기</a>	
	</div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일자</td>
				</tr>
			</thead>
			
			<tbody>
				<c:if test="${empty boardList}">
					<tr>
						<td colspan="3">게시글이 등록되지 않았습니다.</td>
					</tr>
				</c:if>
				<c:if test="${not empty boardList}">
					<c:forEach items="${boardList}" var="b">
						<tr onclick="fnDetail(${b.boardNo})">
							<td>${b.title}</td>
							<td>${b.writer}</td>
							<td>${b.createdAt}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
	
</body>
</html>