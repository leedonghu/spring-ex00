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
	<!-- 파일은 get방식으로 넘어갈 수 없기 때문에 반드시 post 방식으로 넘어가야함  entype도 multipart/form-data로 꼭 존재해야함-->
	<form action="${appRoot }/upload/sub01" method="post" enctype="multipart/form-data">
		name: <input name="fname" value="donghu"><br>
		file: <input type="file" name="ufile" accept="image/*"><br>
		<input type="submit">
	</form>
	
	<hr>
	
	<form action="${appRoot }/upload/sub02" method="post" enctype="multipart/form-data">
		name : <input name="name" value="donghu">
		file : <input name="file" type="file" accept="image/*">
		<input type="submit">
	</form>
</div>
</body>
</html>