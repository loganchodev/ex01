package com.study.erum; // 애플리케이션의 기본 패키지

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 애플리케이션 홈 페이지의 요청을 처리하는 컨트롤러.
 */
@Controller // 이 클래스를 웹 요청을 처리하는 컨트롤러로 선언
public class HomeController {
	
	// 홈 페이지(index)로의 요청을 처리
	@GetMapping("/") // 루트 URL ('/')에 대한 GET 요청을 처리
	public String index() {
		return "index"; // "index" 뷰 이름 반환 -> index 페이지로 이동
	}	
}
