package com.example.demo.controller;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DTO.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("member")
@Slf4j
public class Membercontroller {
	@GetMapping("memberInfo")
	public String memberInfo(Model model) {
		
		MemberDTO mem = new MemberDTO();
		mem.setMemberAge(10);
		mem.setMemberName("000");
		mem.setMemberPhone("010-0000-0000");
		
		model.addAttribute("mem",mem);
		
		List<MemberDTO> memList = new ArrayList();
		memList.add(new MemberDTO("홍길동","010-1234-5678",20));
		memList.add(new MemberDTO("전우치","010-1234-5678",20));
		memList.add(new MemberDTO("각시탈","010-1234-5678",20));
		model.addAttribute("memList", memList);
		
		
		
		return "member/memberInfo";
	}
}
