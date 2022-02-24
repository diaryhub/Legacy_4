<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link href="../resources/css/form.css" rel="stylesheet">

</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
<form class="update_form" action="./update" method="post">
<input type="hidden" name="num" value="${dto.num}" readonly>
<h3>글제목:</h3><input type="text" name="title" value="${dto.title}">
<h3>글내용:</h3><textarea rows="" cols="" name="contents">${dto.contents}</textarea>
<div>
<button type="submit">수정완료</button>
</div>
<h3><a href="./list">취소</a></h3>
</form>
</body>
</html>