<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>선택 결과</title>
</head>
<body>
    <h1>선택 결과</h1>
    <ul>
        <li>1단계 선택: <%= request.getParameter("selection1") %></li>
        <li>2단계 선택: <%= request.getParameter("selection2") %></li>
        <li>3단계 선택: <%= request.getParameter("selection3") %></li>
        <li>4단계 선택: <%= request.getParameter("selection4") %></li>
    </ul>
</body>
</html>
