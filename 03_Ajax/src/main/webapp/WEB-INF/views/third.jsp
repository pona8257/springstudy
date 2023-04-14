<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
<script>
	function fn1(){
		$.ajax({
			// 요청
			type: 'post',							// 서버로 보낼 데이터를 요청 본문(request body)에 저장해서 보낸다. 파라미터 없으니까 post, get이 안됨
			url: '${contextPath}/third/ajax1',
			data: JSON.stringify({					// 문자열 형식의 JSON 데이터를 서버로 보낸다. 파라미터 이름리 없음에 주의한다(서버에서 파라미터로 받을수 없다) ex) 'name=' + $('#name').val 같이 안하고
				'name': $('#name').val(),
				'tel' : $('#tel').val()
			}),
			// 예시 - data: '{"name": "kim", "tel" : "010-1231-124"}'
			contentType: 'application/json', 		// 서버로 보내는 data의 타입을 서버에 알려준다. 그냥 json은 안된다
			// 응답
			dataType: 'json',
			success: function(resData){				// resData = {"name" : "한재형", "tel": "010-123-1241"}
				let str = '<ul>';
				str += '<li>' + resData.name;
				str += '<li>' + resData.tel;
				$('#result').html(str);
			},
			error: function(jqXHR){
				if(jqXHR.status == 400){
					alert('이름과 전화번호는 필수입니다.');
				}
			}
		})
	}
	function fn2(){
		$.ajax({
			// 요청
			type: 'post',
			url: '${contextPath}/third/ajax2',
			data: JSON.stringify({					// 문자열 형식의 JSON 데이터를 서버로 보낸다. 파라미터 이름리 없음에 주의한다(서버에서 파라미터로 받을수 없다) ex) 'name=' + $('#name').val 같이 안하고
				'name': $('#name').val(),
				'tel' : $('#tel').val()
			}),
			contentType: 'application/json',
			dataType: 'json',
			success: function(resData){
				let str = '<ul>';
				str += '<li>' + resData.name;
				str += '<li>' + resData.tel;
				$('#result').html(str);	// 얘는 덮어쓰기 append는 추가 
			},
			error: function(jqXHR){
				if(jqXHR.status == 400){
					alert('이름 또는 전화번호를 확인해주세요');
				}
			}
		})
	}
</script>
</head>
<body>

	<div>
		<form id="frm">
			<div>
				<label for="name">이름</label>
				<input id="name" name="name">
			</div>
			<div>
				<label for="tel">전화번호</label>
				<input id="tel" name="height">
			</div>
			<div>
				<input type="button" value="전송1" onclick="fn1()">
				<input type="button" value="전송2" onclick="fn2()">
			</div>
		</form>
	</div>
	
	<hr>
	
	<div id="result"></div>
	
	
</body>
</html>