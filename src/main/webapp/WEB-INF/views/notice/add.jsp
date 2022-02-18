<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Page</h1>
	<form action="./add" method="post">
	<h3>글제목:</h3> <input type="text" name="title">
	<h3>글내용:</h3> <input type="text" name="contents">
	<h3>작성자:</h3> <input type="text" name="writer">
	<button>ADD</button>
	</form>
</body>
</html>