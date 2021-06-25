<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="bd" tagdir="/WEB-INF/tags/board" %>

<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>
</head>
<body>
<bd:navbar></bd:navbar>

<div class="container">
	
	<h1>글 보기</h1>
	
	<div class="row">
	    <div class="col-12">
	      <form>
	         <div class="form-group">
	         	<label for="input1">제목</label>         
	            <input class="form-control" id="input1" name="title" value="${board.title }" readonly="readonly">
	         </div>
	         <div class="form-group">
	         	<label for="textarea1">내용</label>         
	            <textarea id="textarea1" class="form-control" name="content" readonly="readonly"><c:out value="${board.content }"></c:out></textarea>
	         </div>
	         
	         <div class="form-group">
	            <label for="input2">작성자</label>
	         	<input name="writer" class="form-control" id="input2" value="${board.writer }" readonly="readonly">
	         </div>
	        
	        <c:url value="/board/modify" var="modifyUrl">
	           <c:param name="bno" value="${board.bno }"></c:param>
	           <c:param name="pageNum" value="${cri.pageNum }"></c:param>
	           <c:param name="amount" value="${cri.amount }"></c:param>
	           <c:param name="type" value="${cri.type }"></c:param>
	           <c:param name="keyword" value="${cri.keyword }"></c:param>
	        </c:url>
	        
	         <a class="btn btn-secondary" href="${modifyUrl }">수정/삭제</a>
	      </form>
	    
	    </div>
	</div>
	
</div>
</body>
</html>