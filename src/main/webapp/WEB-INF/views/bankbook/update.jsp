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
	<h1>Bankbook Update Page</h1>

	<form class="update_form" action="./update" method="post">
	<input type="hidden" name="bookNumber" value="${dto.bookNumber}">
	
	<h3>통장이름:</h3><input type="text" name="bookName" value="${dto.bookName}">
	
	<h3>통장설명:</h3><textarea rows="" cols="" name="bookContents" >${dto.bookContents}</textarea>
	<h3>이자율:</h3><input type="text" name="bookRate" value="${dto.bookRate}">
	<h3>판매여부:</h3>
	<div>
	판매 <input type="radio" name="bookSale" value="1"> 판매중지 <input type="radio" name="bookSale" value="0">
	<p></p>
	</div>
	<button type="submit">수정완료</button> <a href="./list"> <input type="button" value="취소"> </a>
	</form>
</body>
</html>
