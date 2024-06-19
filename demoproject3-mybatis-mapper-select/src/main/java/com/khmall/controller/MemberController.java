package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.khmall.dto.Member;
import com.khmall.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {
	@Autowired
	private MemberService MemberService;
	
	@GetMapping("/allMember")
	public String getallMember(Model model) {
		List<Member> memberList = MemberService.getallMember();
		log.info("멤버리스트 조회",memberList);
		model.addAttribute("memberList" , memberList);
		return "memberList";
	}

}
