package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter 
@Setter
@NoArgsConstructor // 기초생성자
@AllArgsConstructor
@ToString
//@어노테이션 이용해서 constructor , getter,setter,toString

public class BlogDTO {
	
	private String commnetName;
	private String commnetOpinion;
}
