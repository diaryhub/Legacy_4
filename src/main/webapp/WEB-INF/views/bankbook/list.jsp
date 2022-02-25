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
	<div class="table_container">
		<h1 class="title">Bankbook List Page</h1>

		<div>
			<form action="./list" method="get">
				<fieldset>
					<select name="kind">
						<option value="col1">제목</option>
						<option value="col2">본문</option>
						<option value="col3">번호</option>
					</select>	
					<input type="text" name="search" value="${pager.search}">
					<button type="submit">검색</button>
				</fieldset>
			</form>
		</div>
		<table class="bankbook_table">
			<thead>
				<tr>
					<th>상품번호</th>
					<th class="table_bookname">통장명</th>
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

		<div>
			<c:if test="${pager.pre}">
				<a href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">&lt;</a>
			</c:if>
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<a href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>

			</c:forEach>
			<c:if test="${pager.next}">
				<a href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">&gt;</a>
			</c:if>
		</div>
		<a href="./add">add</a>
	</div>
</body>
</html>