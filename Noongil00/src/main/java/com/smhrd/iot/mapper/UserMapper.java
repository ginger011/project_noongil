package com.smhrd.iot.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	
	// 사용자 로그인
	public int userLogin(String userID, String userPW);
	
}
