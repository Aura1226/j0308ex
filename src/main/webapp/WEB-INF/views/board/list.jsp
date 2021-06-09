<%@include file="../includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

                    <!-- Page Heading -->
                    <h1 class="h3 mb-4 text-gray-800">List Page</h1>
                    
<table class="table table-bordered">
  <thead class="table-dark">
    <tr>
      <th scope="col">bno</th>
      <th scope="col">title</th>
      <th scope="col">content</th>
      <th scope="col">writer</th>
      <th scope="col">regdate</th>
      <th scope="col">updateDate</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list }" var="board">
    <tr>
      <td><c:out value="${board.bno }"></c:out></td>
      <td><a class="listTitle" href="<c:out value="${board.bno }"/>"><c:out value="${board.title }"></c:out></a></td>
      <td><c:out value="${board.content }"></c:out></td>
      <td><c:out value="${board.writer }"></c:out></td>
      <td><c:out value="${board.regdate }"></c:out></td>
      <td><c:out value="${board.updateDate }"></c:out></td>
    </tr>
  </c:forEach>
  </tbody>
</table>


	<ul class="pagination">
	<c:if test="${pageMaker.prev}">
    <li class="page-item">
      <a class="page-link" href="${pageMaker.start - 1}" tabindex="-1">Previous</a>
    </li>
    </c:if>
    
    <c:forEach begin="${pageMaker.start }" end="${pageMaker.end }" var="num">
    <li class="page-item ${num == pageMaker.pageDTO.page? "active" : ""}"><a class="page-link" href="${num}">${num}</a></li>
    </c:forEach>
    
    <c:if test="${pageMaker.next}">
    <li class="page-item">
      <a class="page-link" href="${pageMaker.end + 1 }">Next</a>
    </li>
    </c:if>
  </ul> 
  
  <form class="actionForm" action="/board/list" method="get">
  	<input type="hidden" name="page" value="${pageDTO.page }">
  	<input type="hidden" name="perSheet" value="${pageDTO.perSheet }">
  </form>
  
  <script>
  document.querySelector(".pagination").addEventListener("click" , e => {
	  e.preventDefault()
	  const target = e.target
	  // console.log(target)
	  const pageNum = target.getAttribute("href")
	  console.log(pageNum)
	  
	  document.querySelector(".actionForm input[name='page']").value = pageNum
	  
	  //console.log(pageNum)
	  document.querySelector(".actionForm").submit()
  },false)
  
  // 조회 이벤트 걸기
  document.querySelectorAll(".listTitle").forEach(a => {
	  a.addEventListener("click" , function(e){
		  e.preventDefault()
		  
		  const bno = e.target.getAttribute("href")
		  
		  const actionForm = document.querySelector(".actionForm")
		  
		  actionForm.setAttribute("action" , "/board/read")
		  actionForm.innerHTML += "<input type='hidden' name='bno' value='"+bno+"'>"
		 
	  },false)
  })
	  
  
  
  
  
  </script>

  

                    
<%@include file="../includes/footer.jsp" %>