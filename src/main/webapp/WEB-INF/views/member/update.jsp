<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="./update" method="post">
	<input type="hidden" name="id" value="${dto.id}">
	<h3>이름:</h3> <input type="text" name="name" value="${dto.name}">
	<h3>이메일:</h3> <input type="text" name="email" value="${dto.email}">
	<h3>전화번호:</h3> <input type="text" name="phone" value="${dto.phone}">
	<button type="submit">수정완료</button>
</form>
</body>
</html>