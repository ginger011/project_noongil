package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Board;
import com.example.demo.service.BoardService;

@RestController
public class RestBoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping(value="/board")
	public List<Board> board(){
		return service.board();
	}
	
	@PostMapping(value="/board/insert")
	public void insert(Board b) {
		service.insert(b);
	}
}
