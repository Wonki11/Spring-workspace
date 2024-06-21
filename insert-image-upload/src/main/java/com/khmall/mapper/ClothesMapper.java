package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Clothes;

@Mapper
public interface ClothesMapper {
	List<Clothes> getAllClothes();
	
	Clothes getClothesId(int clothes_id);
	
	public void uploadClothes(Clothes clothes);

}
