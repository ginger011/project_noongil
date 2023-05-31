package com.smhrd.iot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.iot.domain.UserInfo;
import com.smhrd.iot.service.UserService;

@RestController
public class RestUserController {
	
	@Autowired
	private UserService service;

	// 사용자 추가하기
	@PostMapping("user/insert")
	public void userInsert(UserInfo userInfo) {
		service.userInsert(userInfo);
	}
	
	// 사용자 정보 수정하기
	@PostMapping("user/update")
	public void userUpdate(UserInfo userInfo) {
		service.userUpdate(userInfo);
	}
	
}
