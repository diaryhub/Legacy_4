<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/join.css">
</head>
<body>
	<h1>Login Page</h1>
	<form class="frm" action="./login" method="post">
		<fieldset>
			<legend>ID</legend>
			<input type="text" name="id">
		</fieldset>
		<fieldset>
			<legend>PW</legend>
			<input type="password" name="pw">
		</fieldset>
		<fieldset>
			<button type="submit">Login</button>
		</fieldset>
	</form>
</body>
</html>