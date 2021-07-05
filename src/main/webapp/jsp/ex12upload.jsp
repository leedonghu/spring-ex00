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

	<form action="${appRoot }/uploadex02/sub01" method="post" enctype="multipart/form-data">
		<input type="file" name="file" accept="image/*"><br>
		<input type="submit" value="전송">
	
	</form>
	
</div>
</body>
</html>