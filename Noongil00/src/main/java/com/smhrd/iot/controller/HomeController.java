package com.smhrd.iot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smhrd.iot.domain.Board;

@Controller
public class HomeController {
	
	@GetMapping(value="/")
	public String basic() {
		return "basic";
	}
	// test
	//test2
	//test3
	
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
