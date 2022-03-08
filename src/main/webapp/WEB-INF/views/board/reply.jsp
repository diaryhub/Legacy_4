<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../resources/css/form.css" rel="stylesheet">
<c:import url="../template/header_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>${board} Reply Page</h1>
	<form class="add_form" action="./reply" method="post">
	<input type="hidden" value="${dto.num}" name="num">
	<h3>글제목:</h3> <input type="text" name="title">
	<h3>글내용:</h3> <textarea rows="" cols="" name="contents"></textarea>
	<h3>작성자:</h3> <input type="text" name="writer">
	<button>ADD</button>
	</form>
</body>
</html>