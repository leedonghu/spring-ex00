<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>
</head>
<body>
<div class="container">
	<!-- spirng security test -->
<div>
	<!-- 로그인한 정보를 담은 객체가 보여짐, CustomUser객체(domain) -->
	<!-- CustomerUser객체에서 getMember(db에서 가져온 vo를 담은 객체)를 통해 유저정보가져옴 -->
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal" var="pinfo"/><br>
		${pinfo.member.userid }<br>
		${pinfo.member.userpw }<br>
		${pinfo.member.userName }<br>
	</sec:authorize>
	
	<!-- 로그아웃 되어있을때 ! 를 붙여줌-->
	<!-- principal == String 객체 -->
	<sec:authorize access="!isAuthenticated()">
		<sec:authentication property="principal" var="pinfo"/><br>
		${pinfo }<br>
	
	</sec:authorize>
</div>
</div>
</body>
</html>