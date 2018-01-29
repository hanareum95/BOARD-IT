<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

<link href="<c:url value="/resources/css/home_style.css"/>"
	rel="stylesheet">

<meta charset="UTF-8">
<title>BOARD-IT</title>
</head>
<body>

	<div class="header">
		<img class="img_logo" src="resources/img/boardit.png" />
		<button class="btn_signup">signup</button>
		<button class="btn_login">login</button>
	</div>

	<c:choose>
		<c:when test="${not empty sessionScope.userLoginInfo}">
			<h2>로그인 성공</h2>
		이름 : ${sessionScope.userLoginInfo.userName}<br>
		이메일 : <c:out value="${sessionScope.userLoginInfo.email}" />
			<br>
			<br>
			<a href="logout">로그아웃</a>
			<br>
			<br>
		</c:when>
	</c:choose>

</body>
</html>
