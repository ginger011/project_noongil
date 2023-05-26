package com.smhrd.iot.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserInfo {
	private String userID;
	private String userPW;
	private String userName;
	private String userAddress;
	private String userTel;
	private String userBirth;
	private String caneId;
}
