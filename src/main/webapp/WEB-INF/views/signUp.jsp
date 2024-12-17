<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
    var isIdAvailable = false; // 아이디 사용 가능 여부를 저장하는 변수

    function validateForm() {
        var password = document.getElementById("user_pw").value;
        var confirmPassword = document.getElementById("user_pw_confirm").value;

        if (password !== confirmPassword) {
            alert("비밀번호가 일치하지 않습니다. 다시 입력해 주세요.");
            return false; // 폼 제출을 막음
        }

        if (!isIdAvailable) { // 아이디가 사용 중인 경우
            alert("아이디 중복체크를 해주세요.");
            return false; // 폼 제출을 막음
        }

        return true; // 폼 제출 허용
    }

    $(document).ready(function() {
        $('#checkIdBtn').click(function() {
            const id = $('#user_id').val();

            if (!id) {
                alert("아이디를 입력해주세요.");
                return;
            }

            $.ajax({
                url: '/confirmID',
                type: 'get',
                data: { id: id },
                success: function(response) {
                    alert(response.msg);
                    isIdAvailable = response.msg === "사용 가능한 아이디입니다."; // 아이디 사용 가능 여부 설정
                },
                error: function() {
                    console.log("ajax error");
                }
            });
        });
    });
    </script>
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
        h2 {
            color: #3d7373;
            text-align: center;
        }
        form {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 350px;
        }
        label {
            color: #3d7373;
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"],
        input[type="password"],
        input[type="date"] {
            width: 80%;
            padding: 10px;
            margin: 5px 0 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            background-color: #3d7373;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        button:hover {
            background-color: #2b5454; /* 다크 모드 효과 */
        }
        input[type="submit"] {
            background-color: #3d7373;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #2b5454; /* 다크 모드 효과 */
        }
    </style>
</head>
<body>
    <form action="/signUp" method="post" onsubmit="return validateForm()">
    	<h2>회원가입</h2><br><br>
        <label for="user_name">이름:</label>
        <input type="text" id="user_name" name="user_name" required>

        <label for="user_id">아이디:</label>
        <input type="text" id="user_id" name="user_id"><br>
        <button type="button" id="checkIdBtn">중복 체크</button><br>

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
</body>
</html>
