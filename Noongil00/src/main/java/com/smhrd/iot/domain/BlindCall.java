package com.smhrd.iot.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BlindCall {
	private String userId;
	private String blindCallDestination;
	private String blindCallDate;
}
