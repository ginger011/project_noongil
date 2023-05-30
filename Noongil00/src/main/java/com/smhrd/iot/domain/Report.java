package com.smhrd.iot.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


public class Report {
	
	private int userResportNum;
	private String userID;
	private String userReportPlace;
	private String usetReportContent;
	private String userReportState;
	private String userReportDate;

}
