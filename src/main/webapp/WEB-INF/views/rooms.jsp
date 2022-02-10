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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- 추가한것 -->
<link rel="stylesheet" href="/css/chat.css">
<style>
.form-control:focus {
  box-shadow: none;
}

.form-control-underlined {
  border-width: 0;
  border-bottom-width: 1px;
  border-radius: 0;
  padding-left: 0;
}

</style>
<!--  -->
</head>
<body>
	<div class="container py-5 px-4">
		<header class="text-center">
			<h1 class="display-4 text-white">BTS CHAT ROOM</h1>
			<h3 class="display-4 text-white">name : <sec:authentication property="principal.username"/></h3>
			<p class="text-white lead mb-4">bts chat room <a href="/logout">Log out</a></p>
		</header>
		<div class="row rounded-lg overflow-hidden shadow">
			<!-- Users box-->
			<div class="col-12 px-0">
				<div class="bg-white">
					<form action="/room" method="post">
						<div class="row mb-4 px-4 py-2">
				          <div class="form-group col-md-10">
				            <input id="exampleFormControlInput5" name="name" placeholder="방제" class="form-control form-control-underlined">
				          </div>
				          <div class="form-group col-md-2">
				            <button type="submit" class="btn btn-secondary rounded-pill btn-block shadow-sm">Make</button>
				          </div>
				        </div>
			        </form>
			        <div class="bg-gray px-4 py-2 bg-light">
						<p class="h5 mb-0 py-1">Recent</p>
					</div>
					<div class="messages-box">
						<div class="list-group rounded-0">
							<!-- 채팅방 -->
							<c:forEach items="${list}" var="room">
							<div class="list-group-item list-group-item-action rounded-0" onclick="location.href='/room/${room.roomId}';">
								<div class="media">
									<div class="media-body ml-4">
										<div class="d-flex align-items-center justify-content-between mb-1">
											<h6 class="mb-0">${room.name}</h6>
											<small class="small font-weight-bold">25 Dec</small>
										</div>
										<!-- <p class="font-italic mb-0 text-small">hi</p>  -->
									</div>
								</div>
							</div> 
							</c:forEach>
							<!-- 채팅방 END -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
