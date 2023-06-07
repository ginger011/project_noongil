package com.smhrd.iot.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

//github.com/2021-SMHRD-KDT-IoT-9/Nungil.git


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smhrd.iot.domain.Board;
import com.smhrd.iot.domain.UserInfo;
import com.smhrd.iot.service.BoardService;
import com.smhrd.iot.service.ManagerService;
import com.smhrd.iot.service.UserService;


@Controller
public class HomeController {
	
	@Autowired
	private ManagerService service;
	// @Autowired 1개당 주입은 1개만
	
	@Autowired
	private UserService serviceUser;
	
	
		
	@GetMapping(value="/")
	public String basic() {
		return "index";
	}
	
	// 관리자 로그인
	@PostMapping(value="/web_user")
	public String managerlogin(String managerID, String managerPW, HttpSession session) {
		System.out.println("id: " + managerID + "pw: " + managerPW);
		int result = service.managerlogin(managerID, managerPW);
				
		if(result == 1) { // 로그인 성공
			System.out.println("성공: " + result);
			// 세션에 ID 저장
			session.setAttribute("managerID", managerID);
			
			return "redirect:/"; 
		}else { // 로그인 실패
			System.out.println("실패: " + result);
			return "redirect:/";
		}
	}
	
	// 관리자 로그아웃
	@PostMapping(value="/web_user/logout")
	public String managerlogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
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
	
	// 사용자 정보 수정하기
	@PostMapping("user/update/{userID}")
	public String userUpdate(@PathVariable("userID") String userID,  
			@RequestParam("userTel") String userTel, 
			@RequestParam("userAddress") String userAddress) {
		
		System.out.println("전화번호: " + userTel + "/ 주소: " + userAddress);
		UserInfo userInfo = new UserInfo();
		userInfo.setUserID(userID);
		userInfo.setUserTel(userTel);
		userInfo.setUserAddress(userAddress);
		serviceUser.userUpdate(userInfo);
		return "redirect:/user";
	}
		
		
	// 사용자 추가하기
	@PostMapping("user/insert")
	public String userInsert(UserInfo userInfo) {
		System.out.println(userInfo);
		serviceUser.userInsert(userInfo);
		return "redirect:/user";
	}
		
	// 블록 처리 상태
	@PostMapping("api/saveStatus")
	public String blockState(@RequestBody String status) {
		System.out.println(status);
		
		return "redirect:/userReport";
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
	
	@GetMapping(value="/user/join")
	public String userJoin() {
		return "join";
	}
	
	
}