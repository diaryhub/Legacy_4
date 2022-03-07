<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../resources/css/form.css" rel="stylesheet">
</head>
<body>
	<h1>${board}Add Page</h1>
	<form class="add_form" action="./add" method="post">
	<h3>글제목:</h3> <input type="text" name="title">
	<h3>글내용:</h3> <textarea rows="" cols="" name="contents"></textarea>
	<h3>작성자:</h3> <input type="text" name="writer">
	<button>ADD</button>
	</form>
</body>
</html>