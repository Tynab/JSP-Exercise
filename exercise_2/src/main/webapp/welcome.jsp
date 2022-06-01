<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="./css/welcome.css">
<title>Welcome</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="main">
		<video autoplay loop id="video" plays-inline>
			<source src="./video/background.mp4" type="video/mp4">
		</video>
		<div class="overlay"></div>
		<div class="heading">
			<h1 class="head">
				WELCOME TO OUR <span>WEBSITE</span>
			</h1>
			<h3 class="sub">Lorem ipsum dolor sit amet</h3>
			<form action="" method="post">
				<div class="btns">
					<a href="javascript:$('form').submit()">Logout</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>