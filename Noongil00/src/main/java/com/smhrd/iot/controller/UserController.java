package com.smhrd.iot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smhrd.iot.domain.UserInfo;
import com.smhrd.iot.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService serviceUser;
	// 의존성 주입은 1개만^^ㅋ
	
	// 사용자 정보 가져오기
		@GetMapping(value="/user")
		public String user(Model model, HttpSession session) {
			UserInfo userInfo = new UserInfo();
			List<UserInfo> list = serviceUser.userList();
			model.addAttribute("list", list);
			session.setAttribute("userInfo", userInfo);
			return "user";
		}
}
