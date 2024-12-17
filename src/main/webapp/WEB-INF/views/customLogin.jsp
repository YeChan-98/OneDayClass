<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .login-container {
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 350px;
    }
    h1 {
        color: #3d7373;
        text-align: center;
    }
    h2 {
        color: red; /* 에러 메시지 색상 */
        text-align: center;
    }
    input[type='text'], input[type='password'] {
        width: 90%; /* 너비를 90%로 조정 */
        padding: 10px;
        margin: 10px auto; /* 중앙 정렬을 위해 auto 사용 */
        border: 1px solid #ccc;
        border-radius: 4px;
        display: block; /* 블록 요소로 설정하여 중앙 정렬 */
    }
    input[type='submit'] {
        background-color: #3d7373;
        color: white;
        border: none;
        padding: 10px;
        border-radius: 4px;
        cursor: pointer;
        width: 100%;
    }
    input[type='submit']:hover {
        background-color: #2b5454; /* 다크 모드 효과 */
    }
    .remember-me {
        margin: 10px 0;
        text-align: center; /* 중앙 정렬 */
    }
</style>
</head>
<body>
    <div class="login-container">
        <h1>로그인</h1>
        <h2><c:out value="${error}" /></h2>
        <h2><c:out value="${logout}" /></h2>

        <form method='post' action="/login">
        <input type="hidden" name="redirectUrl" value="${param.redirectUrl}">
            <div>
                <input type='text' name='username' placeholder="사용자 이름" required>
            </div>
            <div>
                <input type='password' name='password' placeholder="비밀번호" required><br><br>
            </div>
            
            <div>
                <input type='submit' value="로그인">
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
        

    </div>
</body>
</html>
