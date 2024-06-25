package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khmall.dto.Member;
import com.khmall.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
//@RestController > 추후 리액트를 사용할 때 사용할 예정
public class Logincontroller {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("m",new Member());
		return "login";
	}
	
	
	@PostMapping("/login")
	public String getLogin(Model model,
							@RequestParam("member_name") String member_name,
							@RequestParam("member_phone") String member_phone,
							HttpSession session) {
		Member member = memberService.getLogin(member_name, member_phone);
		//만약에 로그인한 정보와 일치한다면 그대로 db에서 담아서 가져올 것이기 대문에 null 이 아님
		//하지만 애초에 로그인할 정보가 다르면 DB에서 출력이 되지 않기 때문에 null
		if(member != null) {
			session.setAttribute("loginSession", member); //setter=값을 저장 (저장된정보 , 저장된정보가져옴)
			return "redirect:/";
		}else {
			model.addAttribute("e", "일치하는 아이디 비밀번호가 없습니다.");
			model.addAttribute("m", new Member());
			return "login";
		}
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session /*SessionStatus status 시간지나면 자동로그아웃*/) {

		session.invalidate();//로그인 없던일 만들기
		return "redirect:/";
	}
	
	@GetMapping("/myPage")
	public String showMyPage(HttpSession session, Model model) {
		//현재 로그인이 된 세션의 정보를 가지고 와서 멤버 정보 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession");
		// loginSession의 정보가 member에 담겨서 model.addAttribute("member",member); 의 member에 정보를 담아서 전달
		
		//만약에 로그인이 되어있지 않은데 접촉하려한다. 그러면 바로 홈페이지로 돌려보내자 
		if (member == null) {
			return "redirect:/login";
		}
		// 만약에 모델에 정보가 담겨있으면 보여줄 멤버 객체
		model.addAttribute("member",member);
		return "myPage";
	}
	
	/******** 마이페이지 불러오고 수정하는 GET POST **********/
	@GetMapping("/modifyProfile")
	public String modifyMypage(HttpSession session, Model model) {
		//현재 로그인이 된 세션의 정보를 가지고 와서 멤버 정보 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession");
		// loginSession의 정보가 member에 담겨서 model.addAttribute("member",member); 의 member에 정보를 담아서 전달
		
		//만약에 로그인이 되어있지 않은데 접촉하려한다. 그러면 바로 홈페이지로 돌려보내자 
		if (member == null) {
			return "redirect:/login";
		}
		// 만약에 모델에 정보가 담겨있으면 보여줄 멤버 객체
		model.addAttribute("member",member);
		return "modifyProfile";

	}
	
	@PostMapping("/modifyProfile")
	public String updateMember(HttpSession session, Member updateMember) {
		//현재 로그인이 된 세션의 정보를 가지고 와서 멤버 정보 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession");
		// loginSession의 정보가 member에 담겨서 model.addAttribute("member",member); 의 member에 정보를 담아서 전달
		
		//만약에 로그인이 되어있지 않은데 접촉하려한다. 그러면 바로 홈페이지로 돌려보내자 
		if (member == null) {
			return "redirect:/login";
		}
		
		updateMember.setMember_id(member.getMember_id());
		memberService.updateMember(updateMember);
		session.setAttribute("loginSession", updateMember);
		return "redirect:/myPage";
		
	}
	
	@GetMapping("/deleteMember")
	public String deleteMember(HttpSession session) {
		//현재 로그인이 된 세션의 정보를 가지고 와서 멤버 정보 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession");
		System.out.println("member : " + member);
		// loginSession의 정보가 member에 담겨서 model.addAttribute("member",member); 의 member에 정보를 담아서 전달
		
		//만약에 로그인이 되어있지 않은데 접촉하려한다. 그러면 바로 홈페이지로 돌려보내자 
		if (member == null) {
			return "redirect:/login";
	}
		memberService.deleteMember(member.getMember_id());
		//session에 저장된 멤버 아이디를 가져오겠다. member.getMember_id()
		session.invalidate(); // 삭제후 로그인 없던일로 처리
		return "redirect:/";
	}
	
	//검색하는 화면 보일 수 있도록 @GetMapping
	@GetMapping("/search")
	public String showSearchForm(Model model) {
		return "search";
	}
	
	//검색하는 결과 볼 수 있도록 @PostMapping 
	@PostMapping("/search")
	public String searchMembers(Model model, @RequestParam("keyword") String keyword) {
		List<Member> member = memberService.searchMembers(keyword);
		model.addAttribute("results",member);
		return "search";
	}
}
