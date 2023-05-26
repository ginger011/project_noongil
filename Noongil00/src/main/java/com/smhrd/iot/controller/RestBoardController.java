package com.smhrd.iot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.iot.domain.Board;
import com.smhrd.iot.service.BoardService;

@RestController
public class RestBoardController {

	@Autowired
	private BoardService service;
	
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
}
