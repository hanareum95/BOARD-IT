<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<link href="<c:url value="/resources/css/profile_style.css"/>"
	rel="stylesheet">

<meta charset="UTF-8">
<title>BOARD-IT</title>
</head>

<body>

	<div class="profile-page">
		<div class="form">
			<form class="register-form">
				<p>image</p>
				<p>Name</p>
				<input type="text" placeholder="e.g., hong gildong" />
				<p>Password</p>
				<input type="password" placeholder="e.g., ********" />
				<button>Save</button>
			</form>
		</div>
	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>


</body>
</html>
