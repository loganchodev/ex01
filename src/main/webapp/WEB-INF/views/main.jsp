<%@ page contentType="text/html;charset=UTF-8" language="java" %> <!-- 페이지의 콘텐츠 타입과 문자 인코딩, 사용 언어 설정 -->
<html>
<head>
    <title>main</title> <!-- 문서의 제목 설정 -->
</head>
<body>
<h2>${sessionScope.loginEmail} 님 환영합니다.</h2> <!-- 세션에서 로그인된 사용자의 이메일을 출력하여 환영 메시지 표시 -->
<button onclick="update()">내정보 수정하기</button> <!-- '내정보 수정하기' 버튼: 클릭 시 update() 함수 실행 -->
<button onclick="logout()">로그아웃</button> <!-- '로그아웃' 버튼: 클릭 시 logout() 함수 실행 -->

</body>
<script>
    const update = () => {
        location.href = "/member/update"; // '내정보 수정하기' 버튼 클릭 시 회원 정보 수정 페이지로 이동
    }
    const logout = () => {
        location.href = "/member/logout"; // '로그아웃' 버튼 클릭 시 로그아웃 처리 페이지로 이동
    }
</script>
</html>
