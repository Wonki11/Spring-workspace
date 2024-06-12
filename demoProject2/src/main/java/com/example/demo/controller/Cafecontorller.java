package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.CafeDTO;

import lombok.extern.slf4j.Slf4j;

//@어노테이션 controller requestMapping slf4j 

@Controller 
@RequestMapping("cafe")
@Slf4j
public class Cafecontorller {
	
	//@어노테이션 postMapping(만남의주소)
	//메서드 cafemaincomment 
	
	//@어노테이션 requestParam cafecommentName cafecommentOpinion
	//log info로 들어왔는지 확인
	//log debug로 cafecommentName cafeCommentOpinion 넣기
	//return redirect cafe-index로 돌아가기
	@PostMapping("cafe-index")
	public String Cafe(CafeDTO cafeDTO
			
			/*@RequestParam("cafecommentName")String cafecommentName,
			@RequestParam("cafecommnetOpinion")String cafecommentOpinion*/
			) {
			CafeDTO cd = new CafeDTO();
			cd.getCommnetName();
			cd.getCommnetOpinion();
			
			cd.setCommnetName("아메리카노");
			cd.setCommnetOpinion("맛있다");
			
			log.info("cd 에 작성한 내용 보기" + cd.toString());
			
			 
	/*	log.info("카페 확인");
		log.debug("의견확인 : " + cafecommentOpinion);
		log.debug("이름확인 : " + cafecommentName); */
		
		return "redirect:/cafe/cafe-index";
	}
	
	//CafeDTO cafe_board
	
	
}
