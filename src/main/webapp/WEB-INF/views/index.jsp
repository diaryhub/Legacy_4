<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./template/header_css.jsp"></c:import>


</head>
<body>
	<c:import url="./template/header.jsp"></c:import>
	<div>
	</div>
	<h1>hello</h1><span class="material-icons-outlined">account_circle</span>
	<h1>${member.name}</h1>
	<div>
		<c:if test="${not empty member}">
		<a href="./member/mypage">My Page</a>
		<a href="./member/logout">Log out</a>
		</c:if>
		<a href="./member/login">Login</a>
		<a href="./member/join">Join</a>
	</div>
		
</body>
</html>