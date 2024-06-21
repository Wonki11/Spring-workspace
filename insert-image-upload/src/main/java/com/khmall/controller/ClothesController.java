package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.dto.Clothes;
import com.khmall.servic.ClothesService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j

public class ClothesController {
	@Autowired
	private ClothesService ClothesService;
	
	@GetMapping("/")
	public String getAllClothes(Model model) {
		List<Clothes> clothes = ClothesService.getAllClothes();
		model.addAttribute("clothes",clothes);
		return "index";
	}
	@GetMapping("/clothDetail/{clothes_id}")
	public String getClothesId(Model model, @PathVariable int clothes_id) {
		Clothes clothes = ClothesService.getClothesId(clothes_id);
		model.addAttribute("clothes" , clothes);
		return "clothDetail";
	}
	@GetMapping("/imgUpload")
	public String uploadform(Model model) {
		model.addAttribute("c" , new Clothes()); 
		return "imgUpload";
	}
	
	@PostMapping("/upload")
	public String uploadClothes(
		@RequestParam("clothes_name") String clothes_name,	
		@RequestParam("clothes_price") int clothes_price,	
		@RequestParam("clothes_category") String clothes_category,	
		@RequestParam("clothes_image_path") MultipartFile file	
		, Model model) {
	
		ClothesService.uploadClothes(clothes_name,clothes_price,clothes_category,file);
		return "redirect:/";
		
	}
	
	
}
