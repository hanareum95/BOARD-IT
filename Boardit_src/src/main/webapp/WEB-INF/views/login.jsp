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
			<!-- <form class="register-form">
				<input type="text" placeholder="name" /> 
				<input type="password" placeholder="password" /> 
				<input type="text" placeholder="email address" />
				<button>create</button>
				<p class="message">
					Already registered? <a href="#">Sign In</a>
				</p>
			</form> -->
			<form class="login-form">
				<input type="text" placeholder="username" /> <input type="password"
					placeholder="password" />
				<button class="btn_login">login</button>
				<button class="btn_signup">sign up</button>
			</form>
		</div>
	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>


</body>
</html>
