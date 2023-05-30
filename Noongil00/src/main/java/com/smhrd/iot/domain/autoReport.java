package com.smhrd.iot.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


public class autoReport {
	
	private int autoReportNum;
	private String blockID;
	private String autoReportPlace;
	private String autoReportContent;
	private String autoReportState;
	private String autoReportDate;

}
