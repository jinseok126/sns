<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<style>
.chat-box { border:1px solid; height:300px; width:500px; word-wrap: break-word; }
</style>
<meta charset="UTF-8">
<title>Hello WebSocket</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/sockjs.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/stomp.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
<script>
function showGreeting(message) {
    
    if("${sessionScope.memberId}" == message.split(" : ")[0]) {
    	$("#greetings").append("<div style='float:right;'>" + message.split(" : ")[1] + "</div><br>");
    } else {
    	$("#greetings").append("<div>" + message + "</div>");
    }
    
    $("#name").val("");
}
$(document).ready(function(){
	$( "#send" ).click(function() {
		var id = "${sessionScope.memberId}";
		console.log("id = "+id);
		if(id == "" || id == null) {
			alert("로그인 후 이용 가능합니다.");
		} else { 
			$("#name").val(id+" : "+$("#name").val());
   			sendName(); 
		}
	});
});
</script>
</head>
<body>

<div id="main-content" class="container">
	<div id="greetings" class="chat-box"></div>
    <form class="form-inline">
        <div class="form-group">
            <input type="text" id="name" class="form-control" placeholder="Your name here...">
            <button id="send" class="btn btn-default" type="button">전송</button>
        </div>
    </form>
</div>
</body>
</html>
