// 고장 신고 컨트롤러

package com.smhrd.iot.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;

import com.smhrd.iot.domain.Board;
import com.smhrd.iot.domain.Report;
import com.smhrd.iot.domain.autoReport;
import com.smhrd.iot.service.AutoService;
import com.smhrd.iot.service.BoardService;
import com.smhrd.iot.service.ReportService;

import lombok.extern.apachecommons.CommonsLog;

@RestController
public class RestBoardController {

	@Autowired
	private BoardService service;
	
	@Autowired
	private ReportService Bservice;
	
	@Autowired
	private AutoService AutoService;
	
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
		System.out.println("뭐가있지?1"+service.boardList());
		return service.boardList();// 조건이 필요없을땐 매계인자는 비워져있다.
	}
	
	@GetMapping("/api/breport")
	public List<Report> reportList(){
		System.out.println("뭔데 이게2"+Bservice.reportList());
		return Bservice.reportList();
	}
	
	@GetMapping("/api/autoreport")
	public List<autoReport> autoList(){
		System.out.println("뭔데 이게3"+AutoService.autoList());
		return AutoService.autoList();
	}
	
//	@GetMapping("/on")
//	public ResponseEntity<String> onthermic() {
//	    String filePath = "http://172.30.1.46:8080/on";
//	    // filePath를 사용하여 원하는 동작 수행
//	    // 예를 들어, 외부 API 호출 등
//	    System.out.println(ResponseEntity.ok().body("http://172.30.1.46:8080/on"));
//	    // 성공적인 응답을 반환하고 싶은 경우
//	    return ResponseEntity.ok().body("http://172.30.1.46:8080/on");
//
//	    // 실패한 경우에 대한 처리
//	    // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
//	}

//	@GetMapping("/off")
//	public ResponseEntity<String> offthermic() {
//	    String filePath = "http://172.30.1.46:8080/off";
//	    // filePath를 사용하여 원하는 동작 수행
//	    // 예를 들어, 외부 API 호출 등
//	    System.out.println(ResponseEntity.ok().body("http://172.30.1.46:8080/off"));
//	    // 성공적인 응답을 반환하고 싶은 경우
//	    return ResponseEntity.ok().body("http://172.30.1.46:8080/off");
//
//	    // 실패한 경우에 대한 처리
//	    // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
//	}
}

