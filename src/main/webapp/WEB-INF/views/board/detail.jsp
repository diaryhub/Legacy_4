<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link href="../resources/css/detail.css" rel="stylesheet">
</head>
<body class="notice_detail">
	<c:import url="../template/header.jsp"></c:import>
	
	<div>
	<table class=>
		<tr>
			<td><h3>${dto.num}</h3></td>
			<td><h3>${dto.title}</h3></td>
			<td><h3>${dto.writer}</h3></td>
			<td><h3><fmt:formatDate value="${dto.regDate}" type="time"/><br/></h3></td>
			<td><h3>${dto.hit}</h3></td>
		</tr>
	</table>
	<div>
	<textarea rows="20" cols="80" readonly> ${dto.contents}</textarea>
	<img alt="" src="../resources/upload/notice/${dto.noticeFileDTO.fileName}">
	<h3>${dto.noticeFileDTO.oriName}</h3>
	</div>
	<a href="./update?num=${dto.num}">수정</a>
	<a href="./delete?num=${dto.num}">삭제</a>
	<c:if test="${board ne 'notice'}">
		<a href="./reply?num=${dto.num}">답글</a>
	</c:if>
	</div>
</body>
</html>