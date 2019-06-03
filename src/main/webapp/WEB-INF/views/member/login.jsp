<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/sha256.js"></script>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<script>
$(document).ready(function(){
	
	// alert("test");
	$("#login_btn").click(function(){

		// 비밀번호 암호화
		$('#member_pw').val(SHA256($('#password_temp').val()));
		
		var id = $('#member_id').val();
		var pw = $('#member_pw').val();
		
		$.ajax({
			url : '${pageContext.request.contextPath}/member/login',
			type : 'post',
			data : {
				memberId : 	id,
				memberPw : 	pw,
			},
			success : function(data) {
				
				if(data == "") { 
					alert("회원정보가 일치하지 않습니다!");	
				} else {
					// alert('${sessionScope.memberId}');
					alert('로그인 성공!!');
					
					location.href="${pageContext.request.contextPath}/";
				}
			}, 
			error : function(xhr, status) {
				alert('error');
			}
		})
		
	});
});

</script>
</head>
<body>
<h2 style="text-align: center;">로그인 페이지</h2>
<div>
<!-- <form id="loginForm" name="loginForm" action="${pageContext.request.contextPath}/member/loginExecute" method="post"> -->
	<input type="hidden" id="member_pw" name="memberPw">
	아이디 : &nbsp;&nbsp;
	<input type="text" id="member_id" name="memberId" style="text-align: cetner"><br>
	비밀번호 : <input type="password" id="password_temp" style="text-align: cetner"><br>
	<input type="button" id="login_btn" value="로그인">
<!-- </form> -->
</div>
</body>
</html>