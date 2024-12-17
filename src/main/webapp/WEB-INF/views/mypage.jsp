<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Page</title>
</head>
<body>
    <h1>내 정보</h1>
    
    <c:if test="${not empty sessionScope.loginUser}">
        <h2>환영합니다, ${sessionScope.loginUser.username}님!</h2>
        <ul>
            <li>아이디: ${sessionScope.loginUser.userid}</li>
            <li>이름: ${sessionScope.loginUser.username}</li>
            <li>생년월일: ${sessionScope.loginUser.birth}</li>
            <li>전화번호: ${sessionScope.loginUser.number}</li>
            <li>주소: ${sessionScope.loginUser.addr}</li>
            <li>역할: ${sessionScope.loginUser.role}</li>
        </ul>
    </c:if>
    
    <c:if test="${empty sessionScope.loginUser}">
        <h2>로그인 정보가 없습니다. 로그인 해주세요.</h2>
    </c:if>
    
    <button><a href="/updateMember">수정하기</a></button>
</body>
</html>