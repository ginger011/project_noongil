package com.smhrd.iot.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Report {
	private String userReportNum;
	private String userID;
	private String userReportPlace;
	private String userReportContent;
	private String userReportState;
	private String userReportDate;

}
