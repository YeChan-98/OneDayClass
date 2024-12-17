<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>
    <link rel="stylesheet" href="styles.css"> <!-- 스타일 시트 링크 -->
</head>
<body>

<header>
    <h1>마이페이지</h1>
    <c:if test="${not empty loginUser}">
        <p>${loginUser.username}님, 로그인하셨습니다.</p>
        <a href="customLogout">로그아웃</a>
    </c:if>
    <c:if test="${empty loginUser}">
        <p>로그인하지 않으셨습니다. <a href="/customLogin">로그인</a></p>
    </c:if>
</header>
<br><br>
<main>
    <c:if test="${not empty loginUser}">
        <h2>회원 정보</h2>
        <p>아이디: ${loginUser.userid}</p>
        <p>사용자 이름: ${loginUser.username}</p>
        <p>생년월일: ${loginUser.birth}</p>
        <p>전화번호: ${loginUser.number}</p>
        <p>주소: ${loginUser.addr}</p>
        <a href="/updateMember">정보 수정하기</a> <!-- 정보 수정 페이지로 이동하는 링크 -->
    </c:if>
</main>

<footer>
    <p>&copy; 2024 나의 웹사이트</p>
</footer>
</body>
</html>
