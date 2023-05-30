package com.smhrd.iot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.iot.domain.Board;
import com.smhrd.iot.domain.Report;
import com.smhrd.iot.domain.autoReport;

@Mapper
public interface BoardMapper {
	
	public List<Board> board();
	
	public List<Report> breport();
	
	public List<autoReport> autoreport();


	
//	@Insert("insert into board(title, content, writer) values(#{title}, #{content}, #{writer})")
//	public void insert(Board b);
}

