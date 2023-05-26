package com.smhrd.iot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.smhrd.iot.domain.Board;

@Controller
public class HomeController {
	
	@GetMapping(value="/")
	public String basic() {
		return "index";
	}
	// test
	//test2
	//test3
	
	@GetMapping(value="/map")
	public String map() {
		return "map";
	}
	
	@GetMapping(value="/user")
	public String user() {
		return "user";
	}
	@GetMapping(value="/userReport")
	public String userReport() {
		return "userReport";
	}
	
	@GetMapping(value="/basic")
	public String basic2() {
		return "basic";
	}
	
	@PostMapping(value="/androidApp")
	 public void createMember(@RequestBody Board board) {
        // JSON 데이터를 자바 객체로 변환한 member 객체를 사용하여 회원 생성 로직 수행
        // ...
    }
}
