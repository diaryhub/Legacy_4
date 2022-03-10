<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>My Page</h1>
	<h1>ID:${dto.id}</h1>
	<h1>NAME:${dto.name}</h1>
	<h1>EMAIL:${dto.email}</h1>
	<h1>PHONE:${dto.phone}</h1>
	<img alt="" src="../resources/upload/member/${dto.memberFileDTO.fileName}">
	<h3>${dto.memberFileDTO.oriName}</h3>
	
	<a href="./update?id=${dto.id}">수정</a>
</body>
</html>