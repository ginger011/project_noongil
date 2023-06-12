package com.smhrd.iot.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.smhrd.iot.domain.Board;
import com.smhrd.iot.mapper.BoardMapper;

@Service
public class BoardService {

	@Autowired
	private BoardMapper mapper;
	

	
	public List<Board> boardList(){
		
		System.out.println("인건 먼데 2"+mapper.board());
		return mapper.board();
		
	}
	
//	public String onthermic() {
//		
//		ResponseEntity<String> getData() throws IOException {
//	        // .json 파일 경로
//	        String filePath = "com/smhrd/iot/json/getjson.json";
//		return null;
//	}
//	}
//		
//	
//	public String offthermic() {
//		return null;
//	}

//	public List<Board> board(){
//		return mapper.board();
//	}
//	
//	public void insert(Board b) {
//		mapper.insert(b);
//	}
	

}
