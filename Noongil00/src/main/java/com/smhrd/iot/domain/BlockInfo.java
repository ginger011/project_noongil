package com.smhrd.iot.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BlockInfo {
	private String blockID;
	private String blockAddress;
	private String blockPlace;
	private String blockXCoordinate;
	private String blockYCoordinate;
	
}
