<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bai_tap_nop.service.GameMethod"%>
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
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
	integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
	integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
	crossorigin="anonymous"></script>
<c:set var="showDialog" value="${GameMethod.is_dialog}" scope="request" />
<c:set var="gameState" value="${GameMethod.check_state}"
	scope="request" />
<script>
	$(document).ready(function() {
		var showDialog = "${showDialog}";
		if (showDialog == "true") {
			var gameState = "${gameState}";
			if (gameState == "CORRECT") {
				$('#dialogCongratulation').modal('show');
			} else if (gameState == "EXIST") {
				$('#dialogWarning').modal('show');
			}
		}
	});
</script>
<script>
	function onFocusSelectAll(sender) {
		setTimeout(function() {
			sender.select();
		}, 0);
	}
</script>
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
				<input name="numGuess" value="${savedNum}" class="form-control"
					type="number" placeholder="Số" min="1" max="1000" required
					autofocus onfocus="onFocusSelectAll(this);">
				<div class="btn-set">
					<button name="submit" value="checkin">Dự đoán</button>
				</div>
				<div class="modal fade" id="dialogCongratulation"
					data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
					aria-labelledby="staticBackdropLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="staticBackdropLabel">Thông Báo</h5>
							</div>
							<div class="modal-body">Bạn thật xuất sắc!</div>
							<div class="modal-footer">
								<button name="submit" value="checkout" type="submit"
									class="btn btn-primary">Làm mới</button>
							</div>
						</div>
					</div>
				</div>
			</form>
			<p>${botRep}</p>
		</div>
	</div>
	<div class="modal fade" id="dialogWarning" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">Cảnh Báo</h5>
				</div>
				<div class="modal-body">Số này bạn vừa nhập xong, hãy nhập lại
					số khác!</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Đóng</button>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>