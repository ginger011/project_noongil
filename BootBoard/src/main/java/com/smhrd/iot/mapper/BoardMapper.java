package com.smhrd.iot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.smhrd.iot.domain.Board;

@Mapper
public interface BoardMapper {
	
	public List<Board> board();
	
	@Insert("insert into board(title, content, writer) values(#{title}, #{content}, #{writer})")
	public void insert(Board b);
}
