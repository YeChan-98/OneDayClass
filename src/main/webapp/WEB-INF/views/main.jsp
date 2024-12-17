<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<link rel="stylesheet" href="styles.css">
<!-- 스타일 시트 링크 -->
</head>
<body>
	<header>
		<h1>환영합니다!</h1>
		<c:if test="${not empty loginUser}">
			<p>${loginUser.username}님,환영합니다.</p>
			<a href="customLogout">로그아웃</a>
		</c:if>
		<c:if test="${empty loginUser}">
			<p>
				로그인하지 않으셨습니다. <a href="/customLogin">로그인</a>
			</p>
		</c:if>
	</header>

	<nav>
		<ul>
			<li><a href="/mypage">내 프로필</a></li>
			<li><a href="/signUp">회원가입</a></li>
			<li><a href="/updateMember">수정하기</a></li>
		</ul>
	</nav>

	<main>
		<h2>메인 콘텐츠</h2>
		<p>여기에 메인 페이지의 내용을 추가하세요.</p>
	</main>

	<footer>
		<p>&copy; 2024 나의 웹사이트</p>
	</footer>
</body>
</html>
