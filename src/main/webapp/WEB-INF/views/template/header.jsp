<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <header class="header">
		<nav class="header_wrap">
			<ul>
				<li><a href="/s1/">HOME</a></li>
				<li><a href="/s1/notice/list?name=diary&age=26">공지사항</a></li>
				<li><a href="/s1/qna/list">QnA</a></li>
				<li> <a href="/s1/bankbook/list">통장관리</a></li>
			</ul>
		</nav>
		<nav class="header_sub">
			<ul>
			<c:choose>
			<c:when test="${not empty member}">
				<li><a href="/s1/member/mypage">MyPage</a></li>
				<li><a href="/s1/member/logout">Logout</a></li>		
			</c:when>
			<c:otherwise>
				<li><a href="/s1/member/login">로그인<span class="material-icons icon">login</span></a></li>
				<li><a href="/s1/member/join">회원가입<span class="material-icons icon">person_add</span></a></li>
			</c:otherwise>
			</c:choose>
			
			</ul>
		</nav>
	</header>