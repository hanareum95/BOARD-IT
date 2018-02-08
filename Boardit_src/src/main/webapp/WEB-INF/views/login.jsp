<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<link href="<c:url value="/resources/css/login_style.css"/>"
	rel="stylesheet" >
<script src="<c:url value="/resources/js/login_index.js" />"></script>

<meta charset="UTF-8">
<title>BOARD-IT</title>
</head>

<body>	
	<div class="login-page">
		<div class="form">
			<form class="login-form" id = "loginForm" action = "board" method = "post">
				<input type="text" name="userId" placeholder="ID" /> 
				<input type="password" name="userPassword" placeholder="password" />
				<input class="btn_login" id="submit" type="submit" value="login"/>
				<button class="btn_signup">sign up</button>
			</form>
		</div>
	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
</body>
</html>
