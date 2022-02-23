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
	<h1>Join Page</h1>
	<form action="" class="frm" method="post">
		<fieldset>
			<legend>id</legend>
			<input type="text" name="id">
		</fieldset>
		<fieldset>
			<legend>password</legend>
			<input type="password" name="pw">
		</fieldset>
		<fieldset>
			<legend>name</legend>
			<input type="text" name="name">
		</fieldset>
		<fieldset>
			<legend>email</legend>
			<input type="text" name="email">
		</fieldset>
		<fieldset>
			<legend>phone</legend>
			<input type="number" name="phone">
		</fieldset>
		<button type="submit">회원가입</button>
	</form>
</body>
</html>