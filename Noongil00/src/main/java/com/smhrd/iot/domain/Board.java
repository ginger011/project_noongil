package com.smhrd.iot.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Board {
	private int idx;
	private String title;
	private String content;
	private String writer;
	private String indate;
	
	private String blockID;
	private String address;
	private String blockPlace;
	private String blockXCoordinate;
	private String blockYCoordinate;
}
