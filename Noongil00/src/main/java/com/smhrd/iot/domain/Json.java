package com.smhrd.iot.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
public class Json {
	private String tagTime;
	private String userID;
	private String blockID;
	private int greenLightTime;
	private int redLightTime;

}
