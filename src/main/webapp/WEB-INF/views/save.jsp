<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- 페이지 기본 설정: 언어, 콘텐츠 타입, 인코딩 설정 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> <!-- 문서 문자 인코딩 설정 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> <!-- jQuery 라이브러리 추가 -->
<title>회원가입</title> <!-- 페이지 타이틀 -->
</head>
<body>
	<form action="/member/save" method="post"> <!-- 회원 정보를 서버에 전송하기 위한 폼 -->
		<p>이 메 일 : <input type="text" name="memberEmail" placeholder="이메일" id="memberEmail" onblur="emailCheck()"></p> <!-- 이메일 입력 필드, 포커스를 잃을 때 emailCheck() 함수 실행 -->
		<p id="check-result"> <!-- 이메일 중복 검사 결과를 표시할 요소 -->
		<p>비밀번호 : <input type="text" name="memberPassword" placeholder="비밀번호"></p> <!-- 비밀번호 입력 필드 -->
		<p>이   름 : <input type="text" name="memberName" placeholder="이름"></p> <!-- 이름 입력 필드 -->
		<p>나   이 : <input type="text" name="memberAge" placeholder="나이"></p> <!-- 나이 입력 필드 -->
		<p>전화번호 : <input type="text" name="memberMobile" placeholder="전화번호"></p> <!-- 전화번호 입력 필드 -->
		<input type="submit" value="회원가입"> <!-- 폼 제출 버튼 -->
	</form>
</body>
<script>
// 이메일 중복 검사 함수
const emailCheck = () => {
    const email = document.getElementById("memberEmail").value; // 이메일 입력 필드에서 값 가져오기
    const checkResult = document.getElementById("check-result"); // 결과 표시 요소 선택
    console.log("입력한 이메일", email); // 콘솔에 입력된 이메일 로그
    $.ajax({
        type: "post", // HTTP 요청 방식
        url: "/member/email-check", // 요청을 보낼 서버의 URL
        data: {
            "memberEmail": email // 서버로 전송할 데이터
        },
        success: function(res) { // 요청 성공 시 실행될 콜백 함수
            console.log("요청성공", res); // 성공 로그
            if (res == "ok") { // 서버로부터 받은 응답이 'ok'인 경우
                console.log("사용가능한 이메일");
                checkResult.style.color = "green"; // 결과 텍스트 색상 변경
                checkResult.innerHTML = "사용가능한 이메일"; // 결과 메시지 표시
            } else { // 'ok'가 아닌 다른 응답을 받은 경우
                console.log("이미 사용중인 이메일");
                checkResult.style.color = "red"; // 결과 텍스트 색상 변경
                checkResult.innerHTML = "이미 사용중인 이메일"; // 결과 메시지 표시
            }
        },
        error: function(err) { // 요청 실패 시 실행될 콜백 함수
            console.log("에러발생", err); // 에러 로그
        }
    });
}
</script>
</html>
