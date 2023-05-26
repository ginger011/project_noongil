package com.smhrd.iot.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManagerMapper {
	// 관리자 로그인
	public int managerlogin(String managerID, String managerPW);
}
