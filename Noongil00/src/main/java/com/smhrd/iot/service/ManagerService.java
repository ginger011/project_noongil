package com.smhrd.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.iot.mapper.ManagerMapper;

@Service
public class ManagerService {
	@Autowired
	private ManagerMapper mapper;
	
	// 관리자 로그인
	public int managerlogin(String managerID, String managerPW) {
		return mapper.managerlogin(managerID, managerPW); // 얘 리턴값 int	
	}
}
