package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller 
@Slf4j
@RequestMapping("param2")
public class ParamTwoController{
	@PostMapping("test2")

public String param2(@RequestParam("snackName")String snackName,
		@RequestParam("snackCompany")String snackCompany,
		@RequestParam("snackPrice")int snackPrice,
		@RequestParam(value="snackLike",defaultValue="snackLike",required=false)String snackLike		
		) {




	log.info(snackName);
	log.info(snackCompany);
	log.info("snackPrice" + snackPrice);
	log.info(snackLike);
	//메서드 paramTwoTest
	
	//PostMapping("주소값")
	
	return "redirect:/param/main";
	
	
}
	@PostMapping("LikeSnackCompany")
	public String paramLikeSnackCompany(@RequestParam(value="likeSnack",required=false)String[] likeSnack,
										@RequestParam(value="likeCompany",required=false)List<String> likeCompany
			) {
		log.info("좋아하는 과자 : " + Arrays.toString(likeSnack));
		log.info("선호하는 회사 : " + likeCompany);
		
		
		
		return "redirect:/param/main";
		
		
		
	}

}
	
	
	
	

