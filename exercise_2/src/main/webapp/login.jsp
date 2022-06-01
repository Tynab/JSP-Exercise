<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="./css/login.css">
<title>Login</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="login-box">
		<h2>Login</h2>
		<form action="" method="post" class="form">
			<div class="user-box">
				<input type="text" name="username" required=""> <label>Username</label>
			</div>
			<div class="user-box">
				<input type="password" name="password" required=""> <label>Password</label>
			</div>
			<a href="javascript:$('form').submit()"> <span></span><span></span>
				<span></span> <span></span> Submit
			</a>
		</form>
	</div>
	<c:if test="${not empty checkLogin}">
		<script>
			alert("Login Failed: Your user ID or password is incorrect");
		</script>
	</c:if>
</body>
</html>