<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../resources/detail.css" rel="stylesheet">
</head>
<body>
	<h1>Detail Page</h1>
	<table>
		<tr>
			<td><h3>${dto.num}</h3></td>
			<td><h3>${dto.title}</h3></td>
			<td><h3>${dto.writer}</h3></td>
			<td><h3>${dto.regDate}</h3></td>
			<td><h3>${dto.hit}</h3></td>
		</tr>
	</table>
	<div>
	<textarea rows="10" cols="100" readonly> ${dto.contents}</textarea>
	</div>
	<a href="./update?num=${dto.num}">수정</a>
</body>
</html>