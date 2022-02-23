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
	<h1>Bankbook Add Page</h1>

	<form class="add_form" action="./add" method="post">
	<h3>통장이름:</h3><input type="text" name="bookName">
	<h3>통장설명:</h3><textarea rows="" cols="" name="bookContents"></textarea>
	<h3>이자율:</h3><input type="text" name="bookRate">
	<h3>판매여부:</h3>
	<div>
	판매 <input type="radio" name="bookSale" value="1"> 판매중지 <input type="radio" name="bookSale" value="0">
	<p></p>
	</div>
	<button type="submit">ADD</button>
	</form>
	<h3><a href="./list">취소</a></h3>
</body>
</html>