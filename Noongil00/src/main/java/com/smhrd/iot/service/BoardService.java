package com.smhrd.iot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.iot.domain.Board;
import com.smhrd.iot.mapper.BoardMapper;

@Service
public class BoardService {

	@Autowired
	private BoardMapper mapper;
	
	public List<Board> board(){
		return mapper.board();
	}
	
	public void insert(Board b) {
		mapper.insert(b);
	}
}