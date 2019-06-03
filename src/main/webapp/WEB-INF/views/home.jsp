<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>demo</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#logout").click(function(){
		$.ajax({
			url : '${pageContext.request.contextPath}/member/logout',
			type : 'get',
			success : function(){
				location.href="${pageContext.request.contextPath}/";
			}, 
			error : function(xhr, status){
				alert('로그아웃 실패!!');
			}
		}) // ajax
	}) // click
})// ready
</script>
</head>
<body>

${sessionScope.memberId}
<c:choose>
	<c:when test="${empty sessionScope.memberId}">
		게스트 입니다.<br>
		<a href="${pageContext.request.contextPath}/member/login">로그인</a>
		<a href="${pageContext.request.contextPath}/member/join">회원가입</a>
	</c:when>
	<c:otherwise>
		${sessionSope.memberId}님 환영합니다!<br>
		<a href="/chat">채팅하러 가기</a><br>
		<a id="logout" href="javascript:void(0)">로그아웃</a>
	</c:otherwise>
</c:choose>
</body>
</html>