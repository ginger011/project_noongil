package com.smhrd.iot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.iot.domain.UserInfo;
import com.smhrd.iot.mapper.UserMapper;

@Service
public class UserService {

   @Autowired
   private UserMapper mapper;
   
   // 사용자 로그인
   public int userLogin(String userID, String userPW) {
      return mapper.userLogin(userID, userPW); // 얘 리턴값 int   
   }
   
   // 사용자 전체 가져오기
   public List<UserInfo> userList(){
      return mapper.userList();
   }
	
	// 사용자 추가하기
	public void userInsert(UserInfo userInfo) {
		mapper.userInsert(userInfo);
	}
		
	// 사용자 정보 수정하기
	public void userUpdate(UserInfo userInfo) {
		mapper.userUpdate(userInfo);
	}

}
