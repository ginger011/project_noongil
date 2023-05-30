package com.smhrd.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.iot.domain.UserInfo;
import com.smhrd.iot.service.AndroidService;
import com.smhrd.iot.service.UserService;


@RestController
@RequestMapping("/android")
public class AndroidController {
	@Autowired
	private AndroidService service;
	
	@RequestMapping(value="/androidApp")
	public String createAppMember(@RequestBody String a) {
		
		System.out.println(a);
//		System.out.println(a.getUserID());
//		System.out.println(a.getUserPW());
//		System.out.println(a.getUserName());
//		System.out.println(a.getUserBirth());
//		System.out.println(a.getUserAddress());
//		System.out.println(a.getUserTel());
//		System.out.println(a.getCaneId());
		
		System.out.println("받아짐");
//		service.joinAndroid(a);
		return null;
	}
	
	
	// 사용자 로그인
	//@PostMapping(value="")
	//public String userlogin(String userID, String userPW, HttpSession session) {
//		System.out.println("id: " + userID + "pw: " + userPW);
//		int result = service.userLogin(userID, userPW);
//				
//		if(result == 1) { // 로그인 성공
//			System.out.println("성공: " + result);
//			// 세션에 ID 저장
//			session.setAttribute("userID", userID);
//			return "userReport";
//		}else { // 로그인 실패
//			System.out.println("실패: " + result);
//			return "index";
//		}
	//}

	

	
}
