package com.example.demo.model.dto;
//toString getter setter noargs allargs 

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CafeDTO {
	
	private String commnetName;
	private String commnetOpinion;
}
