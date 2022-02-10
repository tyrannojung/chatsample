<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!--Jstl -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover" />
<link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/webjars/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/sockjs-client/sockjs.min.js"></script>
<script src="/webjars/stomp-websocket/stomp.min.js"></script>
<%@include file="include/chat.jsp" %>
<!-- 추가한것 -->
<link rel="stylesheet" href="/css/chat.css">
<!--  -->
</head>
<body>
	<div class="container py-5 px-4">
		<header class="text-center">
			<h1 class="display-4 text-white">BTS CHAT</h1>
			<h3 class="display-4 text-white">방이름 : ${room.name}</h3>
			<p class="text-white lead mb-4">bts chat api module</p>
			<p class="text-white lead mb-4"><a href="/rooms">room out</a> | <a href="/logout">Log out</a> | <a href="javascript:void(0);" onclick="chat();">SendMessage</a></p>
		</header>
		<div class="text-center">
			<img src="/common/chat/img/sample1.jpg" class="img-thumbnail" alt="Cinque Terre">
			<img src="/common/chat/img/sample2.jpg" class="img-thumbnail" alt="Cinque Terre">
		</div>
	</div>
</body>
</html>
