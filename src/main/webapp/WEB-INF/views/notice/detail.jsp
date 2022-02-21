<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	${dto.contents}
</body>
</html>