package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.Drink;
import com.example.demo.mapper.DrinkMapper;

@Service
public class DrinkService {
	@Autowired 
	private DrinkMapper drinkMapper;
	
	public void insertDrink(Drink drink) {
		drinkMapper.insertDrink(drink);
	}
		

}
