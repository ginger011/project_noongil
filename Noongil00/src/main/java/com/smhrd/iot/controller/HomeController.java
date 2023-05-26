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
}
