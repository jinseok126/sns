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

var id = "${sessionScope.memberId}";
var dis = 0;

function showGreeting(message) {
	if("${sessionScope.memberId}" == message.split(" : ")[0]) {
    	$("#greetings").append("<span style='float:right;'>" + message.split(" : ")[1] + "</span><br>");
    } else {
    	$("#greetings").append("<span>" + message + "</span><br>");
    }
    $("#send").attr("disabled", "disabled");
    $("#msg").val("");
    dis = 0;
}

$(document).ready(function(){
	
	$("#msg").val("");
	$("#send").attr("disabled", "disabled");
	
	$("#send").click(function() {

		if(id == "" || id == null) {
			alert("로그인 후 이용 가능합니다.");
		} else { 
			// var msg = id + " : " +$("#name").val();
			$("#msg").val(id + " : " +$("#msg").val());
			sendMsg($("#msg").val()); 
		}
	});
	 
	$("#msg").keyup(function(e){
		
		// 공백을 제외한 텍스트 입력이 1개 또는 붙여넣기 이벤트가 들어올 경우
		if((dis == 0) && ($.trim($("#msg").val()).length > 0 || e.ctrlKey && e.keyCode == 0x56)) {

			$("#send").attr("disabled", false);
		  	dis = 1;
		  	
		} else if((dis == 1) && ($.trim($(this).val()).length == 0)) {
			
			$("#send").attr("disabled", true);
			dis = 0;
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
            <input type="text" id="msg" class="form-control" placeholder="Your name here...">
            <button id="send" class="btn btn-default" type="button">전송</button>
        </div>
    </form>
</div>
</body>
</html>
