<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
	#review-box {padding: 20px 0 ;}
	
	.hover-group:hover {
    background-color: #f0f8ff; /* 원하는 hover 색상 */
	}
</style>


<%@include file="includes/header.jsp"%>






<div id="schedule-due">
    <h2>수강예정</h2>
    <table class="table">
        <thead>
            <tr>
                <th rowspan="2">번호</th>
                <th>클래스명</th>
                <th>클래스 수강 일</th>
                <th>수강인원</th>
                <th>승인여부</th>
                <th rowspan="2">버튼</th>
            </tr>
            <tr>
            	<th></th>
                <th>결제일</th>
                <th>결제금액</th>
                <th>결제현황</th>
            </tr>
        </thead>

		<!-- 예약 리스트 생성 구간-->
    </table>
</div>






<script type="text/javascript">
$(document).ready(function () {

	const user_id = "user17";
	const tbodyWrap = $('#tbody-wrap');

	reviewService.getListForUser(user_id,function(list){

		let str ="";

		for (let i = 0; i < list.length; i++) {
			const data = list[i];

			console.log(data);

			const product = data.product;
			const reserve = data.reserve;
			const review = data.review;
			const schedule = data.schedule;
			const date = reviewService.StringDate(schedule.schedule);

			const now = new Date();	// 현재 날짜 객체
	

			str += '<tbody class="hover-group"><tr><tr>'
			str += '<td rowspan="2">' + reserve.reserve_no +'</td>'

			str += '<td>'+product.product_title+'</td>'
			str += '<td>'+reviewService.displayTime(date)+" "+date.getHours()+'시</td>'
			str += '<td>'+ reserve.reserve_number +'명</td>'
			str += '<td>' + reviewService.reserveApproval(reserve.reserve_approval) + '</td>'
			str += '<td rowspan="2">';

				if (now < date) { // 현재 날짜가 date보다 이전
					console.log("취소가능")
					str += '<button class="cancel">결제취소</button>';
				} else if (now.toDateString() === date.toDateString() && now.getTime() <= date.getTime()) {
					// 현재 날짜와 date가 같은 날이고, 시간도 같거나 이전
					console.log("취소불가")
					str += "취소 불가능";
				} else { // 현재 날짜가 date 이후 (같은 날짜여도 시간이 이후)
					console.log("클래스완료")
					if((review == null) || (review == "")){
						console.log("리뷰 미작성")
						str +='<button class="review-create">리뷰쓰기</button>';
					}else{
						console.log("리뷰작성후")
						str +='<button class="review-update">리뷰보기</button>';
					}
				}			
			str += '</td></tr>'
			str += '<tr><td></td>'
			str += '<td>'+reviewService.displayTime(reserve.reserve_date)+'</td>'
			str += '<td>'+ formatNumber(reserve.reserve_amount) +'원</td>'
			str += '<td>결제완료</td>'
			str += '</tr>'
			str += '</tbody>'
		}

		$('table').append(str);;

	}); // end reviewService.getListForUser



	//	숫자 , 입력
	function formatNumber(number) {
    	return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}


});	//$(document).ready

</script>
















<%@include file="includes/footer.jsp"%>