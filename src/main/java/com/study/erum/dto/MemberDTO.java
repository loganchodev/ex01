package com.study.erum.dto; // DTO 클래스 패키지 선언

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter // 모든 필드에 대한 getter 메소드 자동 생성 (Lombok)
@Setter // 모든 필드에 대한 setter 메소드 자동 생성 (Lombok)
@ToString // toString() 메소드 자동 생성 (Lombok)
public class MemberDTO {
    private Long id; // 회원 ID
    private String memberEmail; // 회원 이메일
    private String memberPassword; // 회원 비밀번호
    private String memberName; // 회원 이름
    private int memberAge; // 회원 나이
    private String memberMobile; // 회원 연락처
}
