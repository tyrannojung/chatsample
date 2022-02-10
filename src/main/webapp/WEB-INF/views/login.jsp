<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!--Jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1> 
	<form action="/login" method="post"> 
		<div> name: <input type="text" name="username" /> </div> 
		<div> pw: <input type="password" name="password" /> </div> 
		<div> <input type="submit"/> </div> 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
	</form>
	 <br>

    <a href="/signup">sign up</a>

</body>
</html>
</html>