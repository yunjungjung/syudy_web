package com.itwill.springboot5.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
	
	@GetMapping("/signin")
	// SercurityConfig.securityFilterchain 메서드에서 formlogin 아규먼트.
	public void signIn() {
		log.info("GET signIn()");
	}
	
}
