package com.khmall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.khmall.dto.Member;

@Mapper
public interface MemberMapper {
	/*
	 * @Param("member_name") String member_name,
	   @Param("member_phone") String member_phone);
	 @Param 앞에서 매개변수인 
	   
	 * */
	Member getLogin(@Param("member_name") String member_name,
					@Param("member_phone") String member_phone);
}
