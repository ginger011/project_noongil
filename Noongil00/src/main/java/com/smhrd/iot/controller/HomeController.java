package com.smhrd.iot.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

//github.com/2021-SMHRD-KDT-IoT-9/Nungil.git


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.smhrd.iot.domain.UserInfo;
import com.smhrd.iot.service.ManagerService;
import com.smhrd.iot.service.UserService;


@Controller
public class HomeController {
	
	@Autowired
	private ManagerService service;
	// @Autowired 1개당 주입은 1개만^^ㅋ
	
	@Autowired
	private UserService serviceUser;
	
	
		
	@GetMapping(value="/")
	public String basic() {
		return "index";
	}
	

	// 사용자 로그인
//	@PostMapping(value="")
//	public String userlogin(String userID, String userPW, HttpSession session) {
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
//	}

	
		// 관리자 로그인
		@PostMapping(value="/web_user")
		public String managerlogin(String managerID, String managerPW, HttpSession session) {
			System.out.println("id: " + managerID + "pw: " + managerPW);
			int result = service.managerlogin(managerID, managerPW);
					
			if(result == 1) { // 로그인 성공
				System.out.println("성공: " + result);
				// 세션에 ID 저장
				session.setAttribute("managerID", managerID);
				
				return "index";
			}else { // 로그인 실패
				System.out.println("실패: " + result);
				return "index";
			}
		}
	

		// 사용자 정보 가져오기
		@GetMapping(value="/user")
		public String user(Model model, HttpSession session) {
			UserInfo userInfo = new UserInfo();
			List<UserInfo> list = serviceUser.userList();
			model.addAttribute("list", list);
			session.setAttribute("userInfo", userInfo);
			return "user";
		}
		
				

	@GetMapping(value="/map")
	public String map() {
		return "map";
	}
	
	
	
	@GetMapping(value="/userReport")
	public String userReport() {
		return "userReport";
	}
	
	@GetMapping(value="/basic")
	public String basic2() {
		return "basic";
	}
	
	
}
