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
<script>

	$(function(){
		fnList();
	})
	
	function fnList(){
		$.ajax({
			type: 'get',
			url: '${contextPath}/list.json',
			dataType: 'json',
			success: function(resData){	// resData = [{}, {}, {}]
				$('#staffList').empty();	// 초기화 안해주면 계속 중복 되서 쌓인다
				$.each(resData, function(i, staff){
					let str = '<tr>';
					str += '<td>' + staff.sno;
					str += '<td>' + staff.name;
					str += '<td>' + staff.dept;
					str += '<td>' + staff.salary;
					$('#staffList').append(str);
				})		
			}
		})
	}
	
	function fnAdd(){
		$.ajax({
			type: 'post',
			url: '${contextPath}/add.do',
			data: $('#frm_add').serialize(),	// frm 태그로 name속성의 파라미터값을 전달할 때 .serialize() 사용
			dataType: 'text',
			success: function(resData){	// resData = 사원 등록이 성공했습니다.
				alert(resData);
				fnList();	// 사원 목록을 갱신 한다 = 사원 목록을 호출
				$('#sno').val('');
				$('#name').val('');
				$('#dept').val('');
			},
			error: function(jqXHR){	// jqXHR.responseText : 사원 등록이 실패했습니다. (보통 백단에서 예외가 발생하면 에러로 간다.) 
				alert(jqXHR.responseText);
			}
			
		})
	}
	
	function fnSearch(){	// [{}, {}, {}] = lisy로 받아야 되고 {}는 객체 하나이므로 staffDTO 객체로 받아야 한다
		$.ajax({
			type: 'post',
			url: '${contextPath}/search.do',
			data: $('#frm_search').serialize(),
			dataType: 'json',
			success: function(resData){
				$('#staffList').empty();
				let str = '<tr>';
				str += '<td>' + resData.sno;
				str += '<td>' + resData.name;
				str += '<td>' + resData.dept;
				str += '<td>' + resData.salary;
				$('#staffList').append(str);
				
			},
			error: function(jqXHR){	
				alert('조회된 사원이 없습니다');
			}
		})
	}
	
</script>
</head>
<body>
	<!-- form을 보낼때  -->
	<div>
		<h3>사원등록</h3>
		<form id="frm_add">
			<input type="text" name="sno" id="sno" placeholder="사원번호">		
			<input type="text" name="name" id="name" placeholder="사원명">		
			<input type="text" name="dept" id="dept" placeholder="부서명">	
			<input type="button" value="등록" onclick="fnAdd()">	
		</form>
	</div>
	
	<hr>
	
	<div>
		<h3>사원조회</h3>
		<form id="frm_search">
			<input type="text" name="sno" id="sno" placeholder="사원번호입력">
			<input type="button" value="조회" onclick="fnSearch()">
			<input type="button" value="전체" onclick="fnList()">
 		</form>
	</div>
	
	<hr>
	
	<div>
		<h3>사원목록</h3>
		<table border="1">
			<thead>
				<tr>
					<td>사원번호</td>
					<td>사원명</td>
					<td>부서명</td>
					<td>연봉</td>
				</tr>
			</thead>
			<tbody id="staffList"></tbody>
		</table>
	</div>
	
</body>
</html>