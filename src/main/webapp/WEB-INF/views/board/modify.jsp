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
<script>
$(document).ready(function(){
	var modifyUrl = "${appRoot}/board/modify";
	var removeUrl = "${appRoot}/board/remove";
	$("#board-remove-btn1").click(function(){
		if(confirm("삭제 하시겠습니까?")){
			$("#modify-form1").attr("action", removeUrl);
			$("#modify-form1").submit();
		}
	});
});
</script>

</head>
<body>
<bd:navbar></bd:navbar>
<div class="container">

	<h1>글 수정/삭제</h1>
	
	<div class="row">
	    <div class="col-12">
	      <form id="modify-form1" action="${appRoot }/board/modify" method="post">
	         <input hidden name="bno" value="${board.bno }"/>
	         <div class="form-group">
	         	<label for="input1">제목</label>         
	            <input class="form-control" id="input1" name="title" value="${board.title }">
	         </div>
	         <div class="form-group">
	         	<label for="textarea1">내용</label>         
	            <textarea id="textarea1" class="form-control" name="content"><c:out value="${board.content }"></c:out></textarea>
	         </div>
	         
	         <div class="form-group">
	            <label for="input2">작성자</label>
	         	<input name="writer" class="form-control" id="input2" readonly="readonly" value="${board.writer }">
	         </div>
	         
	         <input hidden name="pageNum" value="${cri.pageNum }"/>
	         <input hidden name="amount" value="${cri.amount }"/>
	         <input type="submit" value="수정" class="btn btn-warning" />
	         <input id="board-remove-btn1" type="button" value="삭제" class="btn btn-danger"/>
	      
	      </form>
	    
	    </div>
	</div>
</div>
</body>
</html>