<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/sha256.js"></script>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<script>

</script>
</head>
<body>
<h2 style="text-align: center;">로그인 페이지</h2>
<div>

	<input type="hidden" id="member_pw" name="memberPw">
	아이디 : &nbsp;&nbsp;
	<input type="text" id="member_id" name="memberId" style="text-align: cetner">
	<input type="button" value="아이디 중복점검"><br>
	비밀번호 : <input type="password" id="password_temp" style="text-align: cetner"><br>
	비밀번호 확인 : <input type="password" id="password_temp1" style="text-align: cetner"><br>
	<input type="button" id="login_btn" value="로그인">
	
</div>
</body>
</html>