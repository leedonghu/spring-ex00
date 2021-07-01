<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="bd" tagdir="/WEB-INF/tags/board" %>

<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>

<script>
$(document).ready(function(){
	$("#list-pagenation1 a").click(function(e){
		//기본 액션 중지
		e.preventDefault();
		
		console.log("a요소 클릭됨");
		
		var actionForm = $("#actionForm");
		
		//form의 pageNum input의 값을 a 요소의 href값으로 변경
		actionForm.find("[name=pageNum]").val($(this).attr("href"));
		
		//submit
		actionForm.submit();
	});
});
</script>

</head>
<body>
<div class="container">

    <bd:navbar></bd:navbar>
	
	
	<h1>글 목록</h1>
	<table class="table table-striped">
	 <thead>
	   <tr>
	     <th>#</th>
	     <th>제목</th>
	     <th>작성자</th>
	     <th>작성일</th>
	     <th>수정일</th>
	   </tr>
	 </thead>
	 
	 <tbody>
	   <c:forEach items="${list }" var="board">
	     <tr>
	        <td>${board.bno }</td>
	        <td>
	        <c:url value="/board/get" var="getUrl">
	           <c:param name="bno" value="${board.bno }"></c:param>
	           <c:param name="pageNum" value="${pageMaker.cri.pageNum }"></c:param>
	           <c:param name="amount" value="${pageMaker.cri.amount }"></c:param>
	           <c:param name="type" value="${cri.type }"/>
	           <c:param name="keyword" value="${cri.keyword }"/>
	        </c:url>
	        
	        <a href="${getUrl}">
				${board.title } 
				<c:if test="${board.replyCnt > 0 }">
						[${board.replyCnt }]
				</c:if>
						
			</a>
	        </td>
	        <td>${board.writer }</td>
	        <td>
	        <fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd"/>
	        </td>
	        <td>
	        <fmt:formatDate value="${board.updateDate }" pattern="yyyy-MM-dd"/>
	        </td>
	     
	     </tr>
	   
	   </c:forEach>
	 
	 </tbody>
	</table>
</div>

<div>
<nav aria-label="Page navigation example">
  <ul id="list-pagenation1" class="pagination justify-content-center">
    
    <c:if test="${pageMaker.prev }">
      <li class="page-item">
        <a class="page-link" href="${pageMaker.startPage -1 }" tabindex="-1">Previous</a>
      </li>
    </c:if>
    
    <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="num">
    <%-- href="${appRoot }/board/list?pageNum=${pageMaker.cri.pageNum}&amount=${pageMaker.cri.amount}" --%>
       <li class="page-item ${num == cri.pageNum ? 'active' : '' }"><a class="page-link" href="${num }">${num }</a></li>
    </c:forEach>
    
    <c:if test="${pageMaker.next }">
       <li class="page-item">
         <a class="page-link" href="${pageMaker.endPage + 1 }">Next</a>
       </li>
    </c:if>
    
  </ul>
</nav>

<!-- 페이지 링크용 form -->
<div style="display: none;">
   <form id="actionForm" action="${appRoot }/board/list" method="get">
      <input name="pageNum" value="${cri.pageNum }"/>
      <input name="amount" value="${cri.amount }"/>
      <input name="type" value="${cri.type }"/>
      <input name="keyword" value="${cri.keyword }"/>
   </form>
</div>

</div>


<c:if test="${not empty result }">
<script>
$(document).ready(function(){
	
	
	if(history.state == null){
		
	$("#board-modal1").modal('show');
	history.replaceState({}, null);
	}
});
</script>

<div id="board-modal1" class="modal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">${messageTitle }</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>${messageBody }</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

</c:if>

</body>
</html>