package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//어노테이션 컨트롤러 
@Controller
public class ExampleController {
	
	//어노테이션 겟 매핑 붙인다음 "example" 주소 사용하기
	@GetMapping("example")
	public String example() {
		return "example";
		//이그잼플 html 파일로 돌아가기 작성
	}

}
