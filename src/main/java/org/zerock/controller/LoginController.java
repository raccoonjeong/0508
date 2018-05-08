package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/login")
public class LoginController {
	
	private MemberMapper mapper;
	
	public LoginController(MemberMapper mapper) { //4.3.8버전 이상 가능!!!!!!!!!!
		this.mapper = mapper;
	}

	@GetMapping("")
	public void login() {
		
		log.info("login get");
		
	}
	
	@PostMapping("/action")
	public void loginPost(String username, String password, Model model) {
		//모델은 같이 딸려가는것: 도메인객체
		
		log.info("login post");
		
		//MemberVO member = new MemberVO(username, password);
		MemberVO member = mapper.read(username);
		
		model.addAttribute("member", member);
		
		
	}
}
