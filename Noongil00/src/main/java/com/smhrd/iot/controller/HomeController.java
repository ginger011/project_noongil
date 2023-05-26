package com.smhrd.iot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.smhrd.iot.domain.Board;
import com.smhrd.iot.service.ManagerService;
import com.smhrd.iot.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private ManagerService service;
		
	@GetMapping(value="/")
	public String basic() {
		return "index";
	}
	
//	// 사용자 로그인
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
				return "user";
			}else { // 로그인 실패
				System.out.println("실패: " + result);
				return "index";
			}
		}
		
	
	
	
	
	@GetMapping(value="/thym")
	public String thym(Model model, HttpSession session) {
		//Model:request객체랑 비슷한 역할 (데이터 저장)
		//텍스트 "테스트"
		//주석
		// testt2
		model.addAttribute("test","테스트");
		
		Board b = new Board();
		b.setIdx(1);
		b.setTitle("제목");
		b.setContent("내용");
		b.setWriter("작성자");
		b.setIndate("2023-05-02");
		
		Board b2 = new Board();
		b2.setIdx(2);
		b2.setTitle("제목2");
		b2.setContent("내용2");
		b2.setWriter("작성자2");
		b2.setIndate("2023-05-02");
		
		Board b3 = new Board();
		b3.setIdx(3);
		b3.setTitle("제목3");
		b3.setContent("내용3");
		b3.setWriter("작성자3");
		b3.setIndate("2023-05-02");
		
		List<Board> list = new ArrayList<Board>();
		list.add(b);
		list.add(b2);
		list.add(b3);
		
		model.addAttribute("board", b);
		model.addAttribute("list", list);
		
		session.setAttribute("board2", b2);
		
		return "thymeleaf";
	}
}
