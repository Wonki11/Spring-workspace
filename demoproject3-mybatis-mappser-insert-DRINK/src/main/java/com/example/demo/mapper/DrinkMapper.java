package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.DTO.Drink;

@Mapper
public interface DrinkMapper {
	void insertDrink(Drink drink);

}
