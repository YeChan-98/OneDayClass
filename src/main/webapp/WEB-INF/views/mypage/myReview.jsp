<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
	#review-box {padding: 20px 0 ;}
</style>

<%@include file="includes/header.jsp"%>




<div id="review-box">
<h2>후기</h2>
<table class="table table-hover">
	<thead>
		<tr>
			<th>번호</th>
			<th>클래스명</th>
			<th>클래스일정</th>
			<th>후기제목</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th scope="row">1</th>
			<td>Mark</td>
			<td>Otto</td>
			<td>@mdo</td>
			<td>@mdo</td>
		</tr>
	</tbody>
</table>
</div>
















<%@include file="includes/footer.jsp"%>