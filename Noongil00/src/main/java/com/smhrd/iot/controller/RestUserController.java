package com.smhrd.iot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.iot.domain.UserInfo;
import com.smhrd.iot.service.UserService;

@RestController
public class RestUserController {
	
	@Autowired
	private UserService service;

	
	
}