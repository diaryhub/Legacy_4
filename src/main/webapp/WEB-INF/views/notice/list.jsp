<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List Page</h1>
	<table>
		<tr>
			<td><h3>글번호</h3></td>
			<td><h3>글제목</h3></td>
			<td><h3>작성자</h3></td>
			<td><h3>작성일</h3></td>
			<td><h3>조회수</h3></td>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.num}</td>
				<td><a href="./detail?num=${dto.num}">${dto.title}</a></td>
				<td>${dto.writer}</td>
				<td><fmt:formatDate value="${dto.regDate}" type="time"/><br/></td>
				<td>${dto.hit}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="./add">add</a>
</body>
</html>