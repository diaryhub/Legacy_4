<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link href="../resources/css/table.css" rel="stylesheet">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>Bankbook List Page</h1>
	<table class="bankbook_table">
		<thead>
			<tr>
				<th>상품번호</th>
				<th>통장명</th>
				<th>이자율</th>
				<th>판매여부</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.bookNumber}</td>
					<td><a href="./detail?bookNumber=${dto.bookNumber}">${dto.bookName}</a></td>
					<td>${dto.bookRate}</td>
					<td>${dto.bookSale}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>	
	<a href="./add">add</a>
	<div>
	<c:if test="${pager.pre}"><a href="./list?page=${pager.startNum-1}">&lt;</a></c:if>
	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		<a href="./list?page=${i}">${i}</a>
	
	</c:forEach>
	<c:if test="${pager.next}"><a href="./list?page=${pager.lastNum+1}">&gt;</a></c:if>
	</div>
</body>
</html>