<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../resources/css/detail.css" rel="stylesheet">
<c:import url="../template/header_css.jsp"></c:import>
</head>
<body class="bankbook_detail">
	<c:import url="../template/header.jsp"></c:import>
<h1>Detail Page</h1>
<h1>일련번호:${dto.bookNumber}</h1>
<h1>통장명:${dto.bookName}</h1>
<h1>설명:${dto.bookContents}</h1>
<h1>이자율:${dto.bookRate}</h1>
<h1>판매여부:${dto.bookSale}</h1>
<h2><a href="./list">뒤로</a></h2>
<h2><a href="./update?bookNumber=${dto.bookNumber}">수정</a></h2>
<h2><a href="./delete?bookNumber=${dto.bookNumber}">삭제</a></h2>
</body>
</html>