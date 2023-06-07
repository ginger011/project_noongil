// 신고 관리 서비스 
package com.smhrd.iot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.iot.domain.Report;
import com.smhrd.iot.mapper.BoardMapper;

@Service
public class ReportService {

	
	@Autowired
	private BoardMapper mapper;
	
	public List<Report> reportList(){
		System.out.println("이게 머야22"+mapper.breport());
		return mapper.breport();
	}
	
	// 블록 상태
	public int stateChange(String userReportState, String userReportNum) {
		return mapper.stateChange(userReportState, userReportNum);
	}
	
}
