<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/join.css">
</head>
<body>
	<h1>Login Page</h1>
	<form class="frm" action="./login" method="post">
		<fieldset>
			<legend>ID</legend>
			<input type="text" name="id" value="${cookie.remember.value}">
		</fieldset>
		<fieldset>
			<legend>PW</legend>
			<input type="password" name="pw">
		</fieldset>
		<fieldset>
			<legend>Remember me</legend>
			<input type="checkbox" name="remember" value="1">
		</fieldset>
		<fieldset>
			<button type="submit">Login</button>
		</fieldset>
	</form>
</body>
</html>