package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;


//8085에서 실행
//Slf4j 추가해주고 log.info 접속확인 log.debug 만들어주기 
@Slf4j
@Controller
@RequestMapping("param") // parametercontroller 밑에는 모두 자동으로 맨 앞에 param 붙음
public class Parametercontroller {
	
	@GetMapping("main")
	public String paramMain() {
		return "param/param-main"; // 폴더 param 안에 있는 param-main.html 파일 바라보기 
		
	}
	
	@PostMapping("test1")
	public String paramTest1(HttpServletRequest req) {
		String inputName = req.getParameter("inputName");
		String inputAddress = req.getParameter("inputAddress");
		int inputAge = Integer.parseInt(req.getParameter("inputAge")); // String에서 int로 형변환
		log.info("로그 이름 : " + inputName );
		log.info("로그 주소 : " + inputAddress );
		log.info("로그 나이 : " + inputAge );
		
		return "redirect:/param/main"; // 작성되면 메인으로 돌아가기
		
		
	}
	
	
	
	

}
