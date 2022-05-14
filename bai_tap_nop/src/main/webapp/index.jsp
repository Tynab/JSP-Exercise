<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
</head>

<body>
	<div class="vertical-center">
		<div class="container">
			<img src="./img/animation-log.gif">
			<h1 data-text="*Game*Đoán*Số*">*Game*Đoán*Số*</h1>
			<p>
				(<span>nhập vào tên đăng ký để bắt đầu trò chơi</span>)
			</p>

			<c:choose>
				<c:when test="${playerState=='REGISTERED'}">
					<c:set var="msgbox" value="#msgboxQuestion" />
				</c:when>
				<c:otherwise>
					<c:set var="msgbox" value="" />
				</c:otherwise>
			</c:choose>
			<div>
				<form action="index" method="post">
					<input name="playerName" class="form-control"
						placeholder="tên người chơi" maxlength="20" required>
					<button data-bs-toggle="modal" data-bs-target="${msgbox}">Bắt
						đầu</button>
				</form>
			</div>

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
							<c:set var="no" value="0"></c:set>
							<c:forEach var="player" items="${playerList}">
								<c:set var="no" value="${no+1}"></c:set>
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
	<div class="modal fade" id="msgboxInfomation" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">Thông Báo</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">Đăng ký thành công!</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary">Tiếp tục</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="msgboxQuestion" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">Hỏi</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">Dữ liệu người chơi đã tồn tại, bạn có
					muốn thay thế?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Hủy</button>
					<button type="button" class="btn btn-primary">Đồng ý</button>
					<%response.sendRedirect("game.jsp");%>
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