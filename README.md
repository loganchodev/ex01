# Spring Framework를 이용한 회원 관리 시스템

이 프로젝트는 Spring Framework를 활용하여 회원 가입, 로그인, 회원 정보 조회, 수정 및 삭제 기능을 제공하는 웹 애플리케이션입니다.

## 기능 개요

### 1. 회원 가입
- 사용자는 회원 가입 페이지(`/member/save`)에서 필요한 정보를 입력하여 회원 가입을 요청할 수 있습니다.
- 입력된 사용자 정보는 `MemberService`를 통해 데이터베이스에 저장됩니다.

### 2. 로그인 및 로그아웃
- 로그인 페이지(`/member/login`)에서 이메일과 비밀번호를 입력하여 로그인을 시도할 수 있습니다.
- 로그인 성공 시, 사용자의 세션에 이메일 정보가 저장되고, 메인 페이지로 리다이렉션됩니다.
- 로그아웃(`/member/logout`)을 통해 사용자는 언제든지 로그아웃 할 수 있습니다.

### 3. 회원 정보 조회
- 전체 회원 목록 조회(`/member/`) 및 개별 회원 상세 정보 조회(`/member/?id={id}`) 기능을 제공합니다.
- 사용자는 회원 목록 페이지에서 모든 회원의 정보를 조회할 수 있으며, 특정 회원을 클릭하여 상세 정보를 볼 수 있습니다.

### 4. 회원 정보 수정 및 삭제
- 사용자는 자신의 정보를 수정할 수 있는 페이지(`/member/update`)에 접근할 수 있으며, 수정 후 정보는 데이터베이스에 반영됩니다.
- 특정 회원을 삭제하는 기능(`/member/delete?id={id}`)도 제공합니다.

### 5. 이메일 중복 확인
- 회원 가입 시 이메일 중복 확인(`/member/email-check`)을 비동기 방식으로 처리하여, 이미 등록된 이메일인지 실시간으로 확인할 수 있습니다.

## 기술 스택
- **Front-end**: HTML, CSS
- **Back-end**: Spring Framework, Spring MVC

## 구조

### 컨트롤러(`MemberController`)
- 회원 관련 웹 요청 처리를 담당합니다.
- 각 요청에 따라 적절한 서비스 메소드를 호출하고, 결과에 따른 뷰를 반환합니다.

### 서비스(`MemberService`)
- 실제 비즈니스 로직을 처리합니다.
- 데이터베이스와의 연동을 담당하는 `MemberRepository`와 협력하여 기능을 구현합니다.

### 데이터 전송 객체(`MemberDTO`)
- 클라이언트와 서버 간 데이터 교환을 위한 객체입니다.
- 사용자 정보를 담고 있으며, 데이터베이스와의 데이터 교환에 사용됩니다.

이 프로젝트는 Spring Framework의 MVC 패턴을 활용하여 구현되었으며, 각 계층간의 의존성은 Spring의 DI(Dependency Injection)를 통해 관리됩니다. 또한, 코드의 간결성을 위해 Lombok 라이브러리를 사용하여 Getter, Setter, 생성자 등을 자동으로 생성합니다.
