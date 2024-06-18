package com.example.demo.DTO;

import lombok.*;

@Getter
@Setter 
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Drink {
	private String drinkId;
	private String drinkName;
	private int drinkPrice;
	private int drinkQuantity;

}
