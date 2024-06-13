package com.example.demo.DTO;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
	private String memberName;
	private String memberPhone;
	private int memberAge;
}
