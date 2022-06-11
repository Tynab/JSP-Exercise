<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="bai_tap_nop.service.GameMethod"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/index.css">
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
<c:set var="showMsgbox" value="${GameMethod._isMsgbox_}" scope="request" />
<c:set var="playerState" value="${GameMethod._registerState_}"
	scope="request" />
<script>
	$(document).ready(function() {
		var showMsgbox = "${showMsgbox}";
		if (showMsgbox == "true") {
			var playerState = "${playerState}";
			if (playerState == "REGISTERED") {
				$('#msgboxQuestion').modal('show');
			} else if (playerState == "UNREGISTERED") {
				$('#msgboxInfomation').modal('show');
			}
		}
	});
</script>
</head>
<body>
	<div class="vertical-center">
		<div class="container">
			<img src="./img/animation-log.gif">
			<h1 data-text="*Game*Đoán*Số*">*Game*Đoán*Số*</h1>
			<p>
				(<span>nhập vào tên đăng ký để bắt đầu trò chơi</span>)
			</p>
			<form action="index" method="post">
				<input name="playerName" value="${savedName}" class="form-control"
					placeholder="tên người chơi" maxlength="20" required autofocus>
				<div class="btn-start">
					<button name="submit" value="check">Bắt đầu</button>
				</div>
				<div class="modal fade" id="msgboxInfomation"
					data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
					aria-labelledby="staticBackdropLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="staticBackdropLabel">Thông Báo</h5>
							</div>
							<div class="modal-body">Đăng ký thành công!</div>
							<div class="modal-footer">
								<button name="submit" value="go" type="submit"
									class="btn btn-primary">Tiếp theo</button>
							</div>
						</div>
					</div>
				</div>
				<div class="modal fade" id="msgboxQuestion"
					data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
					aria-labelledby="staticBackdropLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="staticBackdropLabel">Hỏi</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">Dữ liệu người chơi đã tồn tại, bạn
								có muốn thay thế?</div>
							<div class="modal-footer">
								<button name="submit" value="verify" type="submit"
									class="btn btn-primary">Đồng ý</button>
							</div>
						</div>
					</div>
				</div>
			</form>
			<div class="board">
				<h5>Bảng xếp hạng</h5>
				<div class="scrollbar">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">Hạng</th>
								<th scope="col">Tên người chơi</th>
								<th scope="col">Số lần đoán</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="no" value="0" />
							<c:forEach var="player" items="${GameMethod._players_}">
								<c:set var="no" value="${no+1}" />
								<tr>
									<td>${no}</td>
									<td>${player.getPlayerName()}</td>
									<td>${player.getCounter()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
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