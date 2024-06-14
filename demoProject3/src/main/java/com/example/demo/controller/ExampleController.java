package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.MemberDTO;
import com.example.demo.dto.StudentDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;


@Controller // 요청하거나 응답제어 역할을 명시 Bean 등록 = Spring에서 어떤 기능을 하라 설정해놓은 값
@RequestMapping("example") // /example로 시작하는 주소를 해당 컨트롤러에 넣어줌
@Slf4j // lombok 라이브러리가 제공하는 로그 객체 자동생성 어노테이션
public class ExampleController {
	/*
	 * Model
	 * -Spring 에서 데이터 전달 역할을 하는 객체 
	 * - org.springframework.ui 패키지 
	 * - @SessionAttributes와 함께 사용할 경우 session scope 반환
	 *  [기본 사용법]
	 * Model.addAttribute("key"					,value);
	 * Model.addAttribute("html에 전달가능한 이름", 전달할 값을 작성
	 * 
	 * */
	
	@GetMapping("ex1") // /example/ex1 주소로 보여지는 값 
	public String ex1(HttpServletRequest req, Model model) {
	
		
		// 나중에 DB에서 가져온 값을 보여줄 때 사용하는 메서드
		req.setAttribute("test1", "HttpServletRequest로 전달한 값");
		model.addAttribute("test2" , "Model로 전달한 값");
		
		//단일 값(숫자, 문자열) Model을 이용해서 html 전달
		model.addAttribute("ProductName","종이컵");
		
		model.addAttribute("price",2000);
		
		model.addAttribute("productCompany","Khcompany");
		
		// 복수 값(배열,List) Model을 이용해서 html 전달 
		List<String> fruitList = new ArrayList<>();
		fruitList.add("사과");
		fruitList.add("딸기");
		fruitList.add("바나나");
		
		model.addAttribute("fruitList",fruitList);
		
		List<String> animal = new ArrayList<>();
		animal.add("호랑이");
		animal.add("토끼");
		animal.add("거북이");
		
		
		model.addAttribute("animal",animal);
		
		// DTO 객체 Model을 이용해서 html 전달 
		StudentDTO std = new StudentDTO(); 
		std.setStudentNo("12345");
		std.setName("홍길동");
		std.setAge(30);
		
		model.addAttribute("std",std);
		
		MemberDTO mem = new MemberDTO();
		mem.setMemberNo("123");
		mem.setMemberName("전독시");
		mem.setMemberAge(30);
		
		model.addAttribute("mem", mem);
		/*
		 * 별칭,별칭이 아래와 똑같지 않아도 됨 나주엥 이름이 다르면 문제가 생겼을 때 찾기 어렵기 때문에 
		 * a와 b의 별칭을 동일하게 설정해주는 것이 좋음
		 * */
		
		
		//List<StudentDTO> 객체에 Model을 이용해서 html 전달 
		List<StudentDTO> stdList = new ArrayList<>(); 
		
		stdList.add(new StudentDTO("1111" , "홍길동" , 10));
		stdList.add(new StudentDTO("222" , "김이번", 20));
		stdList.add(new StudentDTO("333" , "김삼번", 30));
		
		
		model.addAttribute("stdList", stdList);
		
		//List<MemberDTO> 객체에 Model을 이용해서 html 전달 memList 
		List<MemberDTO> memList = new ArrayList<>();
		
		memList.add(new MemberDTO("100","박세모",40));
		memList.add(new MemberDTO("200","윤세모",60));
		memList.add(new MemberDTO("300","최세모",50));
		
		model.addAttribute("memList",memList);
		
		return "example/ex1"; // templates/example/ex1.html 파일 바라보는 것
	}
	
	/*
	 * @PathVariable
	 * - 주소 중 일부분을 변수 값 처럼 사용
	 * + 해당 어노테이션으로 얻어온 값은 request scope에 세팅
	 * */
	@GetMapping("/ex2/{number}")
	public String pathVariableTest(
			@PathVariable("nember") int number
			// 주소중 {nember} 부분의 값을 가져와 매개변수에 저장
			// + requestScope 세팅
			) {
		return "example/testResult";
	}
	
	@PostMapping("ex2")
	public String ex2(Model model) {
		
		model.addAttribute("str", "<h1> 테스트중&times; </h1>");
		return "example/ex2";
	}
	
	@GetMapping("ex3")
	public String ex3(Model model) {
		model.addAttribute("boardNo",10);
		model.addAttribute("key","제목");
		model.addAttribute("query","검색어");
		
		return "example/ex3";
		
	}
	
	@GetMapping("ex4")
	public String ex4(Model model) {
		//아직 std로 전달해준 값이 없기 때문에 th:unless 안에 작성해준
		// std 없음이 뜨는 것이 정상
		
		StudentDTO std = new StudentDTO("7890","피카츄",30);
		model.addAttribute("std", std);
	
		// 1234 둘리 33
		
		MemberDTO mem = new MemberDTO("1234","둘리",33);
		model.addAttribute("mem", mem);
		
		model.addAttribute("testIf", "테스트중");
		
		//num 100 값을 주고 
		//<h4 th:case="100">AAAAAAAAAA</h4> 
		model.addAttribute("num", 200);
		
		model.addAttribute("alpha", "*");
		
		return "example/ex4";
	}
	
	@GetMapping("ex5")
	public String ex5(Model model) {
		//message 값으로 전달할 값 작성하기
		
		model.addAttribute("message", "타임리프 + 자바스크립트 사용 객체");
		
		//std로  어떤 값ㅇㄹ 저장해서 전달해준 것이 없음
		
		StudentDTO std = new StudentDTO();
		std.setStudentNo("2222");
		model.addAttribute("std", std);

		
		MemberDTO mem = new MemberDTO(); 
		mem.setMemberNo("1");
		mem.setMemberName("홍길동");
		mem.setMemberAge(30);
		model.addAttribute("mem", mem);
		return "example/ex5"; 
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
