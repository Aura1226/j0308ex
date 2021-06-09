<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

                    <!-- Page Heading -->
                    <h1 class="h3 mb-4 text-gray-800">Register Page</h1>
                    
<script>

function sendAjax(data){
	console.log("ajax...." , data)
	// url , {option}
	return fetch("/board/register" , {method : 'post' ,
							   headers : {'Content-type' : 'application/json;charset=utf-8'},
							   body : JSON.stringify(data)})
							   .then(res => console.log(res.text()))
}

const data = {title:"타이틀" , content:"content" , writer:"user"}

const fnResult = sendAjax(data)

fnResult.then(result => {
	console.log("RESULT" + result)
})

</script>                    
                    
<%@include file="../includes/footer.jsp" %>