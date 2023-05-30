// 고장 신고 컨트롤러

package com.smhrd.iot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.iot.domain.Board;
import com.smhrd.iot.domain.Report;
import com.smhrd.iot.service.BoardService;
import com.smhrd.iot.service.ReportService;

@RestController
public class RestBoardController {

	@Autowired
	private BoardService service;
	
	@Autowired
	private ReportService Bservice;
	
//	@GetMapping(value="/board")
//	public List<Board> board(){
//		return service.board();
//	}
	
//	@PostMapping(value="/board/insert")
//	public void insert(Board b) {
//		service.insert(b);
//	}
	
	// 지도 json
	@GetMapping("/api/board")
	public List<Board> boardList(){
		System.out.println("뭐가있지?"+service.boardList());
		return service.boardList();// 조건이 필요없을땐 매계인자는 비워져있다.
	}
	
	@GetMapping("/api/breport")
	public List<Report> reportList(){
		System.out.println("뭔데 이게"+Bservice.reportList());
		return Bservice.reportList();
	}
}
