<%@ page  contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



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
			$.ajax({
				url: "${appRoot}/rest07/sub01",
				data: {
					name: "korea",
					age: 33
				},
				success: function(data){
					console.log(data);
				}
			});
		});
	});
	</script>
	
	<button id="btn1">버튼1</button>
	
	<script>
	$(function(){
		$("#btn2").click(function(){
			$.ajax({
				url: "${appRoot}/rest07/sub02",
				type: "post",
				data: {
					id: "jeju",
					age: 22
				},
				success: function(data){
					console.log(data);
				}
			});
		});
	});
	</script>
	<button id="btn2">버튼2</button>
	
	
	<script>
	$(function(){
		$("#btn3").click(function(){
			$.ajax({
				url: "${appRoot}/rest07/sub03",
				type: "post",
				data: JSON.stringify({
					id: "jeju",
					age: 29
				}),
				success: function(data){
					console.log(data);
				},
				contentType: "application/json"
				
			});
		});
	});
	</script>
	<button id="btn3">버튼3</button>
	
	
		<script>
	$(function(){
		$("#btn4").click(function(){
			$.ajax({
				url: "${appRoot}/rest07/sub04",
				
				success: function(data){
					//받아온 data를 자동으로 객체로 만듬
					console.log(data);
					
					console.log(data.id);
					console.log(data.age);
				},
				contentType: "application/json"
				
			});
		});
	});
	</script>
	<button id="btn4">버튼4</button>
</div>
</body>
</html>