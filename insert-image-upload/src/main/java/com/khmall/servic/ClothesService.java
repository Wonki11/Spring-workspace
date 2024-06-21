package com.khmall.servic;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.dto.Clothes;
import com.khmall.mapper.ClothesMapper;

@Service
public class ClothesService {
	@Autowired
	private ClothesMapper clothesMapper;
	
	public List<Clothes> getAllClothes(){
		return clothesMapper.getAllClothes();
	}
	
	public Clothes getClothesId(int clothes_id) {
		return clothesMapper.getClothesId(clothes_id);
	}
	
	public void uploadClothes(String clothes_name,int clothes_price,String clothes_category,MultipartFile file) {
		String fileName = file.getOriginalFilename();
		System.out.println("file Name : " + fileName);
		
		String uploadDir = "C:/Users/user1/servlet_jsp_workspace/insert-image-upload/src/main/resources/static/images/";
		File imgFile = new File(uploadDir + fileName);
		if( !imgFile.exists()) {
			imgFile.mkdirs();
		}
		
		try {
			file.transferTo(imgFile);
			
			Clothes clothes = new Clothes();
			clothes.setClothes_name(clothes_name);
			clothes.setClothes_category(clothes_category);
			clothes.setClothes_price(clothes_price);
			
			clothes.setClothes_image_path("/images/" + fileName);
			
			clothesMapper.uploadClothes(clothes);
			System.out.println("파일 업로드 Service를 성공적으로 완료 했습니다.");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
