<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<jsp:include page="../layout/header.jsp">
  <jsp:param value="블로그" name="title" />
</jsp:include>
  
<div>
  <h1>블로그 목록</h1>
  
  <c:if test="${sessionScope.loginId ne null}">
    <div>
      <input type="button" value="블로그 작성하기" onclick="fnWrite()">
    </div>
  </c:if>
  
  <div>
    <table border="1">
    <caption style="text-align: center;">${pagination}</caption>
      <thead>
        <tr>
          <td>번호</td>
          <td>제목</td>
          <td>조회수</td>
          <td>작성일</td>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${blogList}" var="blog" varStatus="vs" >
          <tr>
            <td>${beginNo - vs.index}</td>
            <td>
              <c:if test="${sessionScope.loginId eq blog.memberDTO.id}">
                <a href="${contextPath}/blog/detail.do?blogNo=${blog.blogNo}">${blog.title}</a> <!-- 내가 쓴 게시글 들어갈때는 조회수 증가X 바로 detail로 넘어간다 -->
              </c:if>
              <c:if test="${sessionScope.loginId ne blog.memberDTO.id}">            
              <a href="${contextPath}/blog/increseHit.do?blogNo=${blog.blogNo}">${blog.title}</a> <!-- 남이 쓴 게시글 들어갈때는 조회수 증가O -->
              </c:if>
            </td>
            <td>${blog.hit}</td>
            <td>${blog.memberDTO.id}</td>
            <td>${blog.createdAt}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
  
</div>

<script>
  function fnWrite(){
	  location.href = '${contextPath}/blog/write.form';
  }
</script> 
  
</body>
</html>