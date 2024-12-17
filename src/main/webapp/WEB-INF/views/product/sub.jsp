<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/sub.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.1/css/all.min.css" integrity="sha512-5Hs3dF2AEPkpNAR7UiOHba+lRSJNeM2ECkwxUIxC1Q/FLycGTbNapWXB4tP889k5T5Ju8fs4b1P5z/iB4nMfSQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0c68d32e05a45a04086b754916025b65"></script>

<title>클래스 상세페이지</title>
</head>
<body>

	
	
	

<div class="page-wrapper">
<%@include file="../includes/header.jsp" %>



	<div class="container">
		
		<div class="title_box">
			<h2 class="sub_title">${product.product_title}</h2>
			<button class="sub_modify" onclick="location.href='/product/modify?product_no=${product.product_no}'">수정</button>
			<button class="sub_delete">삭제</button>
		</div>
		
		<div class="delete_popup">
			<form class="delete_form" action="/product/remove" method="post">
				<input name="product_no" type="hidden" value="${product.product_no}">
				<i class="fa-solid fa-triangle-exclamation"></i>
				<h5>정말 이 클래스를 삭제하시겠습니까?</h5>
				<p>삭제된 클래스는 다시 복구할 수 없습니다.</p>
				<div>
					<button class="delete_btn" type="submit">삭제</button>
					<button class="cancel_btn">취소</button>				
				</div>
			</form>
		</div>
		
		
		
		
		
		
		
		
		<div class="detail_wrapper">
			<div class="detail_left">
				<div class="img_box" style="background-image:url('/resources/img/class_main_img/${product.main_img}')"></div>
				<div class="detail_bottom">
					<div class="detail detail_1">
						<h3 class="detail_title">클래스 소개</h3>
						<h4>${product.product_title}</h4>
						${product.class_detail_1}
					</div>
					<div class="detail detail_2">
						<h3 class="detail_title">이런 분들이 들으면 좋아요</h3>
						${product.class_detail_2}
					</div>
					<div class="detail detail_3">
						<h3 class="detail_title">커리큘럼</h3>
						${product.class_detail_3}
					</div>
					<div class="detail detail_4">
						<h3 class="detail_title">제공사항</h3>
						${product.class_detail_4}
					</div>
					<div class="detail detail_5">
						<h3 class="detail_title">유의사항</h3>
						${product.class_detail_5}
					</div>
					<div class="detail detail_6">
						<h3 class="detail_title">위치</h3>
						<input class="location_code_value" type="hidden" value="${product.location_code}">
						<p>${product.location}</p>
						<div id="map"></div>
					</div>
					<div class="detail detail_7">
						<h3 class="detail_title">후기</h3>
						<%-- <%@include file="../class/review.jsp" %> --%>
					</div>
					<div class="detail detail_8">
						<h3 class="detail_title">문의</h3>
						<%-- <%@include file="../class/question.jsp" %> --%>
					</div>
				</div>
			</div>
		
		
			<div class="detail_right">
				<div class="detail_right_inner">
				<form class="reserve_form" action="/product/confirm" method="get">
					<label class="schedule_label" for="class_schedule">클래스 일정 선택</label>
					<select class="schedule_select" name="class_schedule" id="class_schedule">
						<c:forEach var="schedule" items="${scheduleList}">
							<option class="schedule_option">${schedule.schedule}</option>
						</c:forEach>
					</select>
					<div class="people">
						<input class="max" type="hidden" value="${product.max_capacity}">
						<input class="price" type="hidden" value="${product.price_per_person}">
						<input class="selected_schedule" name="selected_schedule" type="hidden" value="">
						<input class="reserve_amount" name="reserve_amount" type="hidden" value="">
						<input class="reserve_number" name="reserve_number" type="hidden" value="">
						<input class="product_no" name="product_no" type="hidden" value="${product.product_no}">
					
						<p class="text">인원수 선택</p>
						<div class="number_box">
							<button class="minus_btn">-</button>
							<div class="number">1</div>
							<button class="plus_btn">+</button>
						</div>
						<div class="price_box">
							<span class="price2"></span> 원/ <span class="number2">1</span> 인
						</div>
					</div>
				
					<button class="ask_btn">문의하기</button>
					<button class="apply_btn">클래스 신청하기</button>
				</form>
				</div>
				<div class="border">
			</div>
			
			
		</div>
	</div>
	</div>
	<%@include file="../includes/footer.jsp" %>
</div>
	
	
	
	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	
	<script>
	
		var height = $(".container").height();
		console.log(height);
		$(".detail_right").height(height);
	
		var max = $(".max").val();		
		var price = $(".price").val()*1;	
		var num = 1;
		var price_reg = price.toLocaleString();
		
		$(".price2").html(price_reg);
	
		$(".plus_btn").on("click", function(e){
			e.preventDefault();
			
			if(num >= max){
				 num = max;
			}else{
				num += 1;
			}
		
			$(".number").html(num);
			$(".number2").html(num);
			
			var real_price = price*num;
			var real_price_reg = real_price.toLocaleString();
			
			
			$(".price2").html(real_price_reg);
		});
		
		$(".minus_btn").on("click", function(e){
			e.preventDefault();
			
			if(num <= 1){
				num = 1;
			}else{
				num -= 1;
			}
			
			$(".number").html(num);
			$(".number2").html(num);
			
			var real_price = price*num;
			var real_price_reg = real_price.toLocaleString();
			
			
			$(".price2").html(real_price_reg);
		});
		
		$(".apply_btn").on("click", function(e){
			e.preventDefault();
			
			var selected_schedule = $("select[name=class_schedule]").val();
			$(".reserve_form").find("input[name='selected_schedule']").val(selected_schedule);
			console.log($(".selected_schedule").val());
			
			var reserve_number = $(".number").html();
			$(".reserve_form").find("input[name='reserve_number']").val(reserve_number);
			console.log($(".reserve_number").val());
			
			var reserve_amount = $(".price2").html();
			$(".reserve_form").find("input[name='reserve_amount']").val(reserve_amount);
			console.log($(".reserve_amount").val());
			
			$(".reserve_form").submit();
		});
		
		$(".sub_delete").on("click", function(e){
			$(".delete_popup").show();
		});
		
		$(".cancel_btn").on("click", function(e){
			e.preventDefault();
			$(".delete_popup").hide();
		});
		
		$(".delete_btn").on("click", function(e){
			e.preventDefault();
			$(".delete_form").submit();
		});
	
		
		
		
		var location_code_value = $(".location_code_value").val().split(',');
		var location_code_a = location_code_value[0];
		var location_code_b = location_code_value[1];
		
		
		const container = document.getElementById('map'); // 지도를 담을 영역의 DOM 레퍼런스
        let options = { // 지도를 생성할 때 필요한 기본 옵션
            center: new kakao.maps.LatLng(location_code_a, location_code_b), // 지도의 중심좌표
            level: 3 // 지도의 레벨(확대, 축소 정도)
        };
        let map = new kakao.maps.Map(container, options); // 지도 생성 및 객체 리턴

        // 마커를 생성합니다
        let markerPosition = new kakao.maps.LatLng(location_code_a, location_code_b); // 마커의 위치
        let marker = new kakao.maps.Marker({
            position: markerPosition // 마커의 위치
        });

        marker.setMap(map); // 지도의 마커를 설정합니다
		
	</script>

</body>
</html>