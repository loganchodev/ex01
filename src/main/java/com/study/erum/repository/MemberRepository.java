package com.study.erum.repository; // 리포지토리 패키지 선언

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.study.erum.dto.MemberDTO;

import lombok.RequiredArgsConstructor;

@Repository // 리포지토리 빈으로 선언
@RequiredArgsConstructor // Lombok으로 final 필드에 대한 생성자 자동 생성
public class MemberRepository {
	
	private final SqlSessionTemplate sql; // MyBatis의 SqlSessionTemplate 의존성 주입

	// 회원 정보 저장
	public int save(MemberDTO memberDTO) {
		System.out.println("memberDTO=" + memberDTO);
		return sql.insert("Member.save", memberDTO); // MyBatis를 사용한 insert 쿼리 실행
	}

	// 로그인 처리
	public MemberDTO login(MemberDTO memberDTO) {
		return sql.selectOne("Member.login", memberDTO); // 로그인 쿼리 실행
	}

	// 모든 회원 정보 조회
	public List<MemberDTO> findAll() {
		return sql.selectList("Member.findAll"); // 전체 회원 조회 쿼리 실행
	}

    // ID를 이용한 특정 회원 정보 조회
    public MemberDTO findById(Long id) {
		return sql.selectOne("Member.findById", id); // ID로 회원 조회 쿼리 실행
	}

    // 회원 정보 삭제
    public void delete(Long id) {
		sql.delete("Member.delete", id); // 회원 삭제 쿼리 실행
	}

    // 이메일을 이용한 회원 정보 조회
    public MemberDTO findByMemberEmail(String loginEmail) {
		return sql.selectOne("Member.findByMemberEmail", loginEmail); // 이메일로 회원 조회 쿼리 실행
	}
	
	// 회원 정보 업데이트
	public int update(MemberDTO memberDTO) {
		return sql.update("Member.update", memberDTO); // 회원 정보 업데이트 쿼리 실행
	}

}
