<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/game.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<title>Game Đoán Số</title>
</head>
<body>
	<div class="vertical-center">
		<div class="container">
			<img src="./img/animation-run.gif">
			<h3>
				Tôi đang nghĩ tới một số từ 1 đến 1000.<br>Bạn có thể đoán được
				không?
			</h3>
			<form action="game" method="post">
				<input name="numGuess" class="form-control" type="number"
					placeholder="Số" min="1" max="1000" required>
				<button>Dự đoán</button>
			</form>
			<p>${botRep}</p>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>