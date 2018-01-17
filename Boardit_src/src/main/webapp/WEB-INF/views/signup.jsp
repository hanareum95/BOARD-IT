<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<link href="<c:url value="/resources/css/signup_style.css"/>"
	rel="stylesheet">

<meta charset="UTF-8">
<title>BOARD-IT</title>
</head>

<body>

	<div class="signup-page">
		<div class="form">
			<form class="register-form" id = "signupForm" action = "signup" method = "post">
				<h3>Create a BOARD-IT Account</h3>
				<p>Name</p>
				<input type="text" name="userName" placeholder="e.g., hong gildong" />
				<p>E-mail</p>
				<input type="text" name="userId" placeholder="e.g., board@it.com" />
				<p>Password</p>
				<input type="password" name="userPassword" placeholder="e.g., ********" />
				<input id="submit" type="submit" value="Create a new Account"/>
			</form>
		</div>
	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>


</body>
</html>
