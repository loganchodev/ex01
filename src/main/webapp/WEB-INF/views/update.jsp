<%@ page contentType="text/html;charset=UTF-8" language="java" %> <!-- 페이지 기본 설정: 콘텐츠 타입, 문자 인코딩, 사용 언어 설정 -->
<html>
<head>
    <title>update</title> <!-- 문서 제목 설정 -->
</head>
<body>
    <form action="/member/update" method="post" name="updateForm"> <!-- 회원 정보 수정을 위한 폼, 서버에 데이터 전송 -->
        id: <input type="text" name="id" value="${member.id}" readonly> <!-- 사용자 ID 입력 필드(수정 불가) -->
        email: <input type="text" name="memberEmail" value="${member.memberEmail}" readonly> <!-- 이메일 입력 필드(수정 불가) -->
        password: <input type="text" name="memberPassword" id="memberPassword"> <!-- 비밀번호 입력 필드 -->
        name: <input type="text" name="memberName" value="${member.memberName}" readonly> <!-- 이름 입력 필드(수정 불가) -->
        age: <input type="text" name="memberAge" value="${member.memberAge}"> <!-- 나이 입력 필드 -->
        mobile: <input type="text" name="memberMobile" value="${member.memberMobile}"> <!-- 연락처 입력 필드 -->
        <input type="button" value="수정" onclick="update()"> <!-- '수정' 버튼, 클릭 시 update() 함수 호출 -->

    </form>
</body>
<script>
    const update = () => {
        const passwordDB = '${member.memberPassword}'; // 서버에서 받아온 비밀번호
        const password = document.getElementById("memberPassword").value; // 사용자가 입력한 비밀번호
        if (passwordDB == password) {
            document.updateForm.submit(); // 비밀번호가 일치하면 폼 제출
        } else {
            alert("비밀번호가 일치하지 않습니다!"); // 일치하지 않으면 경고 메시지 표시
        }
    }
</script>
</html>
