<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="header_wrapper">
	<div class="header">
		<h1 class="header_title">
			<a href='/'>CLASS IT</a>
		</h1>
		<div class="header_btns">
			<c:choose>
				<c:when test="${not empty sessionScope.loginUser}">
					<span>환영합니다, ${sessionScope.loginUser.username}님.</span>
					<button class="login_btn">
						<a href="/mypage">마이페이지</a>
					</button>
					<!-- <form action="/customLogout" method="post" style="display: inline;">
						<input type="hidden" name="redirectUrl"
							value="${pageContext.request.requestURI}${pageContext.request.queryString != null ? '?' + pageContext.request.queryString : ''}" />
						<button type="submit" class="join_btn">로그아웃</button>
					</form>-->
					<button class="login_btn" onclick="redirectToLogout()">로그아웃</button>

				</c:when>
				<c:otherwise>
					<button class="login_btn" onclick="redirectToLogin()">로그인</button>
					<button class="join_btn">
						<a href="/signUp">회원가입</a>
					</button>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>

<script>
	function redirectToLogin() {
		// 현재 페이지의 URL을 가져옵니다.
		var currentUrl = window.location.href;
		// 로그인 페이지로 리다이렉트합니다. 원래 URL을 쿼리 파라미터로 추가합니다.
		window.location.href = "/customLogin?redirectUrl="
				+ encodeURIComponent(currentUrl);
	}
	
	function redirectToLogout() {
		// 현재 페이지의 URL을 가져옵니다.
		var currentUrl = window.location.href;
		// 로그인 페이지로 리다이렉트합니다. 원래 URL을 쿼리 파라미터로 추가합니다.
		window.location.href = "/customLogout2?redirectUrl="
				+ encodeURIComponent(currentUrl);
	}
</script>