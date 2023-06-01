package com.smhrd.iot.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReportNonUser {
	private String nonUserID;
	private String nonUserReportPlace;
	private String nonUserReportContent;
	private String nonUserReportState;

}
