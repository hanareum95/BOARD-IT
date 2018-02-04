<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<link href="<c:url value="/resources/css/board_style.css?v=28"/>"
	rel="stylesheet">

<script src="<c:url value="/resources/js/board.js?v=72" />"></script>

<meta charset="UTF-8">
<title>BOARD-IT</title>
<body>
	<div class="header">
		<img class="img_logo" src="resources/img/boardit.png" />

		<p class="user_name">mini_son</p>
	</div>

	<div class="content">

		<div class="ct_personal">
			<div class="ct_personal_header">
				<button class="btn_personal_plus" id="btn_personal_plus"
					type="submit">
					<img class="btn_img" src="resources/img/btn_plus.png">
				</button>

				<p class="p_personal">Personal Board</p>
			</div>

			<div class="ct_personal_board">
				<ul class="boardList" id="personalList">

					<li><a href="https://www.w3schools.com" id="a_school">SAMPLE</a></li>

				</ul>

			</div>


		</div>

		<div class="ct_team">
			<div class="ct_team_header">
				<button class="btn_team_plus" id="btn_team_plus" type="submit">
					<img class="btn_img" src="resources/img/btn_plus.png">
				</button>

				<p class="p_team">Team Board</p>
			</div>

			<div class="ct_team_board">
				<ul class="boardList" id="teamList">

					<li><a href="https://www.w3schools.com" id="a_school">SAMPLE</a></li>

				</ul>

			</div>


		</div>



	</div>


</body>
</html>