<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>
</head>
<body>
<div class="container">

	<script>
	$(function(){
		
		
		$("#btn1").click(function(){
			var data = {
					bno: 1,
					reply: "댓글",
					replyer: "user00"
				}
			
			$.post({
				url: "${appRoot}/replies/new",
				data: JSON.stringify(data), //객체를 string으로 바꿔줌
				contentType: "application/json",
				success: function(data){
					console.log(data);
				},
				error: function(){
					console.log("등록실패");
				}
			});
		});
		
		$("#btn2").click(function(){
			var data = {
					bno: 1000,
					reply: "댓글",
					replyer: "user00"
				}
			
			$.post({
				url: "${appRoot}/replies/new",
				data: JSON.stringify(data), //객체를 string으로 바꿔줌
				contentType: "application/json",
				success: function(data){
					console.log(data);
				},
				error: function(){
					console.log("등록실패");
				}
			});
		});
	});
	</script>
	<h5>입력테스트</h5>
	<button id="btn1">TEST CREATE -SUCCESS</button>
	<button id="btn2">TEST CREATE -FAIL</button>
	
	
	
	<hr>
	<script>
	$(function(){
		$("#btn3").click(function(){
			var bno = 44;
			
			$.get({
				url: "${appRoot}/replies/page/" + bno,
				success: function(data){
					console.log(data);
				}
			});
		});
	});
	</script>
	
	<h5>목록 테스트</h5>
	<button id="btn3">TEST LIST</button>
	
	<hr>
	
	<script>
	$(function(){
		$("#btn4").click(function(){
			var rno = 13;
			
			$.get({
				url: "${appRoot}/replies/" + rno,
				success: function(data){
					console.log(data);
				}
			});
		});
	})
	</script>
	<h5>댓글 하나</h5>
	<button id="btn4">TEST GET</button>
	
	<hr>
	<script>
	$(function(){
		$("#btn5").click(function(){
			var rno = 3;
			$.ajax({
				type: "delete",
				url: "${appRoot}/replies/" + rno,
				success: function(){
					console.log("delete success");
				},
				error: function(){
					console.log("delete fail");
				}
			});
		});
	});
	</script>
	
	<h5>댓글 삭제</h5>
	<button id="btn5">TEST DELETE</button>
	
	<hr>
	<script>
	$(function(){
		$("#btn6").click(function(){
			var rno = 7;
			var data = {
					rno: rno,
					bno : 44,
					reply: "수정된 댓글!!!!",
					replyer: "donghu"
			};
			$.ajax({
				type: "put",
				url: "${appRoot}/replies/" +rno,
				data: JSON.stringify(data),
				contentType: "application/json",
				success: function(){
					console.log("success update");
				},
				error: function(){
					console.log("fail upadate");
				}
			});
		});
	});
	</script>
	
	<h5>댓글 수정</h5>
	<button id="btn6">TEST UPDATE</button>
	
	<hr>
	<script>
	$(function(){
		$("#btn7").click(function(){
			var rno = $("#input1").val();
			var bno = $("#input2").val();
			var reply = $("#input3").val();
			var replyer = $("#input4").val();
			
			var data = {
					rno: rno,
					bno: bno,
					reply: reply,
					replyer: replyer
			};
			
			$.ajax({
				type: "put",
				url: "${appRoot}/replies/" +rno,
				data: JSON.stringify(data),
				contentType: "application/json",
				success: function(){
					console.log("success update");
				},
				error: function(){
					console.log("fail upadate");
				}
			});
			
		});
	});
	</script>
	
	<h5>댓글 수정 form</h5>
	
	<input id="input1" name="rno" value="9" readonly><br>
	<input id="input2" name="bno" value="44" readonly><br>
	<input id="input3" name="reply" placeholder="댓글 입력"><br>
	<input id="input4" name="replyer" placeholder="작성자 입력"><br>
	<button id="btn7">TEST UPDATE form</button>
</div>
</body>
</html>