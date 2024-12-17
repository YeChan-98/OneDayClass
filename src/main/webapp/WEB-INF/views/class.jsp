<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
</style>
		<!-- jQuery 라이브러리 -->
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>


</head>
<body>
<table class="table">
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>메인</td>
      <td>메인</td>
      <td>@메인</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>메인</td>
      <td>메인</td>
      <td>@메인</td>
    </tr>

  </tbody>
</table>
<%@include file="./class/review.jsp" %>
<%@include file="./class/question.jsp" %>
</body>
</html>