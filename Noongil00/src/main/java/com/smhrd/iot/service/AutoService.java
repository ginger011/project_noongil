// 신고 관리 서비스 
package com.smhrd.iot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.iot.domain.autoReport;
import com.smhrd.iot.mapper.BoardMapper;

@Service
public class AutoService {

	
	@Autowired
	private BoardMapper mapper;
	
	public List<autoReport> autoList(){
		System.out.println("이게 머야22"+mapper.autoreport());
		return mapper.autoreport();
	}
	
}