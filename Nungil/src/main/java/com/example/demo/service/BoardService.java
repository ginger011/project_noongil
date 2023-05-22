
  package com.example.demo.service;
  
 import java.util.List;
  
 import org.springframework.beans.factory.annotation.Autowired; import
 org.springframework.stereotype.Service;
 
 import com.example.demo.domain.Board; import
 com.example.demo.mapper.BoardMapper;
 
 @Service public class BoardService {
 
 @Autowired private BoardMapper mapper;
 
 public List<Board> board(){ return mapper.board(); }
 
 public void insert(Board b) { mapper.insert(b); } }
 