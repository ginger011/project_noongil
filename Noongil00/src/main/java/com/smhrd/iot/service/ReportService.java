package com.smhrd.iot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.iot.domain.Report;
import com.smhrd.iot.mapper.BoardMapper;

@Service
public class ReportService {

	
	@Autowired
	private BoardMapper Rmapper;
	
	public List<Report> reportList(){
		return Rmapper.breport();
	}
	
}
