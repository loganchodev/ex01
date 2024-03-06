package com.study.erum.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.erum.dto.MemberDTO;
import com.study.erum.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service // 서비스 계층을 나타내는 스프링 컴포넌트 어노테이션
@RequiredArgsConstructor // Lombok으로 final 필드에 대한 생성자 자동 생성
@Transactional // 클래스 레벨에서 트랜잭션 관리 활성화
public class MemberService {
	
	private final MemberRepository memberRepository; // 회원 정보 접근을 위한 레포지토리 의존성 주입

	// 회원 정보 저장
	public int save(MemberDTO memberDTO) {
		return memberRepository.save(memberDTO); // 레포지토리를 통한 저장 처리
	}

	// 로그인 처리
	public boolean login(MemberDTO memberDTO) {
		MemberDTO loginMember = memberRepository.login(memberDTO); // 로그인 시도
		return loginMember != null; // 결과에 따른 boolean 반환
	}

	// 모든 회원 정보 조회
	public List<MemberDTO> findAll() {
		return memberRepository.findAll(); // 레포지토리를 통한 전체 조회 처리
	}

    // ID를 이용한 특정 회원 정보 조회
    public MemberDTO findById(Long id) {
		return memberRepository.findById(id); // 레포지토리를 통한 ID 조회
	}

    // 회원 정보 삭제
    public void delete(Long id) {
        memberRepository.delete(id); // 레포지토리를 통한 삭제 처리
    }

    // 이메일을 이용한 회원 정보 조회
    public MemberDTO findByMemberEmail(String loginEmail) {
        return memberRepository.findByMemberEmail(loginEmail); // 레포지토리를 통한 이메일 조회
    }

    // 회원 정보 업데이트
    public boolean update(MemberDTO memberDTO) {
        int result = memberRepository.update(memberDTO); // 업데이트 처리
        return result > 0; // 결과에 따른 boolean 반환
	}

    public String emailCheck(String memberEmail) {
        MemberDTO memberDTO = memberRepository.findByMemberEmail(memberEmail);
        if(memberDTO == null){
            return "ok";
        }else{
            return "no";
        }
    }
	
}
