<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원 정보 수정</title>
    <link rel="stylesheet" href="styles.css"> <!-- 스타일 시트 링크 -->
    <script>
    window.onload = function() {
        var birthInput = document.getElementById("user_birth");
        var birthValue = birthInput.value;
        birthInput.value = birthValue.split(" ")[0]; // "1996.10.10"만 남김
    };

    function validateForm() {
        var password = document.getElementById("user_pw").value;
        var confirmPassword = document.getElementById("user_pw_confirm").value;

        if (password !== confirmPassword) {
            alert("비밀번호가 일치하지 않습니다. 다시 입력해 주세요.");
            return false; // 폼 제출을 막음
        }
        return true; // 폼 제출 허용
    }
    </script>
</head>
<body>

<header>
    <h1>회원 정보 수정</h1>
    <c:if test="${not empty loginUser}">
        <p>${loginUser.username}님, 로그인하셨습니다.</p>
        <a href="/customLogout">로그아웃</a>
    </c:if>
    <c:if test="${empty loginUser}">
        <p>로그인하지 않으셨습니다. <a href="/customLogin">로그인</a></p>
    </c:if>
</header>
<br><br>
<main>
    <c:if test="${not empty loginUser}">
        <form action="/updateMember" method="post" onsubmit="return validateForm();">
            <label for="user_id">아이디:</label>
            <input type="text" name="user_id" value="${loginUser.userid}" readonly/><br/>
            
            <label for="user_name">사용자 이름:</label>
            <input type="text" id="user_name" name="user_name" value="${loginUser.username}" required/><br/>

            <label for="user_pw">비밀번호:</label>
            <input type="password" id="user_pw" name="user_pw" required><br/>
            
            <label for="user_pw_confirm">비밀번호 확인:</label>
            <input type="password" id="user_pw_confirm" name="user_pw_confirm" required><br/>
            
            <label for="user_birth">생년월일:</label>
            <input type="text" id="user_birth" name="user_birth" value="${loginUser.birth}" required/><br/>
            
            <label for="user_number">전화번호:</label>
            <input type="text" id="user_number" name="user_number" value="${loginUser.number}" required/><br/>

            <label for="user_addr">주소:</label>
            <input type="text" id="user_addr" name="user_addr" value="${loginUser.addr}" required><br/>

            <input type="submit" value="수정하기"/>
        </form>
    </c:if>
</main>

<footer>
    <p>&copy; 2024 나의 웹사이트</p>
</footer>
</body>
</html>
