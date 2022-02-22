<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./template/header_css.jsp"></c:import>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
	<c:import url="./template/header.jsp"></c:import>
	<h1>hello</h1><span class="material-icons">login</span>
	<h1>${member.name}</h1>
	<div>
		<c:if test="${not empty member}">
		<a href="./member/mypage">My Page</a>
		<a href="./member/logout">Log out</a>
		</c:if>
		<c:if test="${empty member}">
		<a href="./member/login">Login</a>
		<a href="./member/join">Join</a>
		</c:if>

	</div>
</body>
</html>