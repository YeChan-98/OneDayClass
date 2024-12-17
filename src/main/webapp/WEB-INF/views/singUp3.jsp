<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
    <script>
        var idChecked = false; // 아이디 중복 체크 상태

        function validateForm() {
            var password = document.getElementById("user_pw").value;
            var confirmPassword = document.getElementById("user_pw_confirm").value;

            if (!idChecked) {
                alert("아이디 중복체크를 해주세요.");
                return false; // 폼 제출을 막음
            }

            if (password !== confirmPassword) {
                alert("비밀번호가 일치하지 않습니다. 다시 입력해 주세요.");
                return false; // 폼 제출을 막음
            }
            return true; // 폼 제출 허용
        }

        function checkID() {
            var userId = document.getElementById("user_id").value;
            if (userId === "") {
                alert("아이디를 입력해 주세요.");
                return;
            }

            // AJAX 요청으로 중복 체크
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "/confirmID", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    var response = JSON.parse(xhr.responseText);
                    var message = response.count >= 1 ? "사용할 수 없는 아이디입니다." : "사용할 수 있는 아이디입니다.";
                    document.getElementById("modalMessage").innerText = message;
                    document.getElementById("modal").style.display = "block";

                    if (response.count === 0) {
                        document.getElementById("useButton").style.display = "inline"; // 사용 버튼 보이기
                    } else {
                        document.getElementById("useButton").style.display = "none"; // 사용 버튼 숨기기
                    }
                }
            };
            xhr.send("user_id=" + encodeURIComponent(userId));
        }

        function useID() {
            idChecked = true; // 아이디 사용 상태로 변경
            document.getElementById("modal").style.display = "none"; // 모달 닫기
            alert("아이디가 사용 가능합니다.");
        }

        function closeModal() {
            document.getElementById("modal").style.display = "none"; // 모달 닫기
        }
    </script>
    <style>
        /* 모달 스타일 */
        #modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgb(0,0,0);
            background-color: rgba(0,0,0,0.4);
            padding-top: 60px;
        }
        #modalContent {
            background-color: #fefefe;
            margin: 5% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
        }
    </style>
</head>
<body>
    <h2>회원가입</h2>
    <form action="/signUp" method="post" onsubmit="return validateForm()">
        <label for="user_name">이름:</label>
        <input type="text" id="user_name" name="user_name" required><br>

        <label for="user_id">아이디:</label>
        <input type="text" id="user_id" name="user_id"><br>
        <button type="button" onclick="checkID()">중복 체크</button><br>

        <label for="user_pw">비밀번호:</label>
        <input type="password" id="user_pw" name="user_pw" required><br>
        
        <label for="user_pw_confirm">비밀번호 확인:</label>
        <input type="password" id="user_pw_confirm" name="user_pw_confirm" required><br/>

        <label for="user_birth">생년월일:</label>
        <input type="date" id="user_birth" name="user_birth" required><br>

        <label for="user_number">전화번호:</label>
        <input type="text" id="user_number" name="user_number" required><br>

        <label for="user_addr">주소:</label>
        <input type="text" id="user_addr" name="user_addr" required><br>

        <input type="submit" value="가입하기">
    </form>

    <!-- 모달 -->
    <div id="modal">
        <div id="modalContent">
            <span onclick="closeModal()" style="cursor:pointer; float:right;">&times;</span>
            <p id="modalMessage"></p>
            <button id="useButton" style="display:none;" onclick="useID()">사용하기</button>
        </div>
    </div>
</body>
</html>
