package com.study.erum.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.erum.dto.MemberDTO;
import com.study.erum.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller // 웹 요청 처리 컨트롤러
@RequestMapping("/member") // '/member'로 시작하는 모든 요청 처리
@RequiredArgsConstructor // 필수 인자(final 필드) 생성자 자동 생성(Lombok)
public class MemberController {
	
	private final MemberService memberService; // 회원 서비스 의존성 주입

	@GetMapping("/save") // 회원 가입 폼 페이지
	public String saveForm() {
		return "save"; // 회원 가입 폼 페이지 반환
	}
	
	@PostMapping("/save") // 회원 가입 처리
	public String save(@ModelAttribute MemberDTO memberDTO) {// 클라이언트 요청에서 전송된 데이터를 MemberDTO 타입 객체로 바인딩
		int saveResult = memberService.save(memberDTO); // 회원 정보 저장
		return saveResult > 0 ? "login" : "save"; // 성공 시 로그인 페이지, 실패 시 가입 폼
	}
	
	@GetMapping("/login") // 로그인 폼 페이지
	public String loginForm() {
		return "login"; // 로그인 폼 페이지 반환
	}
	
	@PostMapping("/login") // 로그인 처리
	public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
		boolean loginResult = memberService.login(memberDTO); // 로그인 시도
		if (loginResult) {
			session.setAttribute("loginEmail", memberDTO.getMemberEmail()); // 세션에 이메일 저장
			return "main"; // 메인 페이지로 리다이렉션
		}
		return "login"; // 실패 시 로그인 페이지 재이동
	}
	
    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }	 
 	
	@GetMapping("/") // 전체 회원 조회
	public String findAll(Model model) {
		List<MemberDTO> memberList = memberService.findAll(); // 모든 회원 정보 조회
		model.addAttribute("memberList", memberList); // 모델에 회원 정보 추가
		return "list"; // 회원 목록 페이지 반환
	}
	
	@GetMapping // 특정 회원 상세 정보 조회
	public String findById(@RequestParam("id") Long id, Model model) {
		MemberDTO member = memberService.findById(id); // id로 회원 정보 조회
		model.addAttribute("member", member); // 모델에 회원 정보 추가
		return "detail"; // 상세 정보 페이지 반환
	}
	
	@GetMapping("/delete") // 회원 삭제
	public String delete(@RequestParam("id") Long id) {
		memberService.delete(id); // id로 회원 정보 삭제
		return "redirect:/member/"; // 회원 목록 페이지로 리다이렉션
	}
	
	@GetMapping("/update") // 회원 정보 수정 폼
	public String updateForm(HttpSession session, Model model) {
		String loginEmail = (String) session.getAttribute("loginEmail"); // 세션에서 이메일 추출
		MemberDTO member = memberService.findByMemberEmail(loginEmail); // 이메일로 회원 정보 조회
		model.addAttribute("member", member); // 모델에 회원 정보 추가
		return "update"; // 수정 폼 페이지 반환
	}
	
	@PostMapping("/update") // 회원 정보 수정 처리
	public String update(@ModelAttribute MemberDTO memberDTO) {
		boolean result = memberService.update(memberDTO); // 회원 정보 업데이트 시도
		return result ? "redirect:/member?id=" + memberDTO.getId() : "index"; // 성공 시 상세보기, 실패 시 인덱스
	}
	
	@PostMapping("/email-check") // 비동기, 이메일 중복 확인
	public @ResponseBody String emailCheck(@RequestParam("memberEmail") String memberEmail){
	    System.out.println("memberEmail = " + memberEmail);
	    String checkResult = memberService.emailCheck(memberEmail);
	    return checkResult;
	}
}
