package com.khmall.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor


public class Clothes {
	private int clothes_id;
	private String clothes_name;
	private int clothes_price;
	private String clothes_category;
	private String clothes_image_path;
}
