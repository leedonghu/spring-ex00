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
			$.ajax({
				url: "${appRoot}/rest09/sub01",
				type: "post",
				data: {
					id: "donghu",
					age: 29
				},
				success: function(data){
					console.log("btn1", data);
				},
				dataType: "json"
			});
		});
		
		$("#btn2").click(function(){
			$.post({
				url: "${appRoot}/rest09/sub01",
				data:{
					id: "lee",
					age: 30
				},
				success: function(data){
					console.log("btn2", data)
				},
				dataType: "json"
			});
		});
		
		$("#btn3").click(function(){
			$.post("${appRoot}/rest09/sub01", 
					{id:"leedonghu", age:29},
					function(data){
					console.log("btn3", data);	
				}, 
				"json");
		});
	});
	</script>
	
	<button id="btn1">버튼1</button>
	<button id="btn2">버튼2</button>
	<button id="btn3">버튼3</button>
</div>
</body>
</html>