<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/resources/css/common_for_index.css" />
<link rel="stylesheet" href="/resources/css/index.css" />

<title>클래스잇</title>
</head>
<body>


	<div class="page-wrapper">

		<div class="header_wrapper">
			<div class="header">
				<p>당 신 이 원 하 는 모 든 클 래 스</p>
				<h1 class="header_title">
					<a href='/'>C L A S S I T</a>
				</h1>
				<div class="header_btns">
					<button class="search_btn" onclick="location.href='/product/list'">클래스
						보기</button>
					<button class="recomm_btn" onclick="location.href='/select'">클래스
						추천</button>
					<c:choose>
						<c:when test="${not empty sessionScope.loginUser}">
							<button class="login_btn" onclick="location.href='/mypage'">마이페이지</button>
							<button class="join_btn" onclick="location.href='/customLogout'">로그아웃</button>
						</c:when>
						<c:otherwise>
							<button class="login_btn" onclick="location.href='/customLogin'">로그인</button>
							<button class="join_btn" onclick="location.href='/signUp'">회원가입</button>
						</c:otherwise>
					</c:choose>

				</div>
				<div class="header_menu"></div>
			</div>
		</div>

		<div class="main_img"></div>
		<div class="main_img_cover"></div>

		<div class="container"></div>
	</div>

</body>
</html>