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






	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${memberList}" var="member">
				<tr>
					<td>${member.user_id}</td>
					<td>${member.user_password}</td>
					<td>${member.user_name}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>



</body>
</html>
