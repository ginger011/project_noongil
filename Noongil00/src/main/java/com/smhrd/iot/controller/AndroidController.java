package com.smhrd.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.iot.domain.UserAndroidInfo;
import com.smhrd.iot.domain.UserInfo;
import com.smhrd.iot.service.AndroidService;
import com.smhrd.iot.service.UserService;


@RestController
@RequestMapping("/android")
public class AndroidController {
	@Autowired
	private AndroidService service;
	
	@RequestMapping(value="/androidApp")
	public ResponseEntity<String> createAppMember(@RequestBody UserInfo a) {
		System.out.println(a.getUserID());
		System.out.println(a.getUserPW());
		System.out.println(a.getCaneId());
		System.out.println(a.getUserName());
		System.out.println(a.getUserAddress());
		System.out.println(a.getUserTel());
		System.out.println(a.getUserBirth());
		
		
		System.out.println("받아짐");
		service.userAndroidJoin(a);
		return ResponseEntity.ok("data 저장성공!");
	}
	
	
//	 사용자 로그인
	@RequestMapping(value = "/androidAppLogin", produces = "application/json")
	@ResponseBody
	public String userAndroidLogin(@RequestBody UserAndroidInfo userInfoLogin) {
	    System.out.println("id: " + userInfoLogin.getUserID() + " pw: " + userInfoLogin.getUserPW());
	    UserAndroidInfo result = service.userAndroidLogin(userInfoLogin);
	    if (result != null) { // 로그인 성공
	        System.out.println("성공: " + result);
	        return "{\"status\": \"success\"}";
	    } else { // 로그인 실패
	        System.out.println("실패: " + result);
	        return "{\"status\": \"failure\"}";
	    }
	
}
	

}
