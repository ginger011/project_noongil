package com.smhrd.iot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.iot.domain.UserInfo;
import com.smhrd.iot.service.UserService;

@RestController
public class RestUserController {
	
	@Autowired
	private UserService service;
	
//	// 사용자 전체 가져오기
//	@GetMapping("/api/user")
//	public List<UserInfo> userList(){
//		return service.userList();
//		
//	}
	
	// 사용자 추가하기
	@PostMapping("user/insert")
	public void userInsert(UserInfo userInfo) {
		
	}
	
}
