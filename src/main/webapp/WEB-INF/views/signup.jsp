<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!--Jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
</head>
<body>
	<h1>sign up Page</h1>
	<form action="/user" method="POST">
      email : <input type="text" name="email"> <br>
      password : <input type="password" name="password"> <br>
      <input type="radio" name="auth" value="ROLE_ADMIN,ROLE_USER"> admin
      <input type="radio" name="auth" value="ROLE_USER" checked="checked"> user <br>
      <button type="submit">Join</button>
    </form> <br>
    <a href="/login">Go to login →</a>
</body>
</html>
