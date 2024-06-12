package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.BlogDTO;

import lombok.extern.slf4j.Slf4j;

//어노테이션(@ 이용해서, controller , requestMapping, slf4j 설정

@Controller 
@Slf4j 
@RequestMapping("blog")
public class BlogController {
	//메서드명 : blogComment
	//어노테이션(@) 이용해서 PostMapping(commnet) 만들고
	// @RequestParam이용해서 blog-index.html 파일에 작성
	// commentName, commentOpinion 작성 
	// required = true 
	// return "redirect:/blog/blog-index"
	@PostMapping("comment")
	public String blogComment(BlogDTO blogDTO
							  /*ModelAttribute 사용해서 변경 BlogDTO blogDTO 
							   * @RequestParam("commentName")String commentName,
							  @RequestParam("commentOpinion") String commentOpinion
							   * */
			) {
		log.info("블로그 댓글 작성 공간");
		
		BlogDTO bd = new BlogDTO();
		bd.getCommnetName();
		bd.getCommnetOpinion();
		
		bd.setCommnetName("홍길동");
		bd.setCommnetOpinion("잘봤습니다.");
				
		log.info("bd 에 작성한 내용 보기" + bd.toString());
		
	/*	log.debug("commentName " + commentName);
		log.debug("commentOpinion " + commentOpinion);
		
		log.info("블로그 댓글 작성 완료하고 다시 블로그 메인페이지로 돌아가기"); */
		
		return "redirect:/blog/blog-index";
	}
}
