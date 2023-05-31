package com.smhrd.iot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.iot.domain.UserInfo;

@Mapper
public interface UserMapper {
	
	// 사용자 로그인
	public int userLogin(String userID, String userPW);
	
	// 사용자 전체 가져오기
	public List<UserInfo> userList();
	
	// 사용자 추가하기
	public void userInsert(UserInfo userInfo);
	
	// 사용자 정보 수정
	public void userUpdate(UserInfo userInfo);
}
