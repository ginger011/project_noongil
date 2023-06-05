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
	private String userPW2;
	private String caneId;
	private String userName;
	private String userAddress;
	private String userTel;
	private String userBirth;
	@Override
	public String toString() {
		return "UserInfo [userID=" + userID + ", userPW=" + userPW + ", caneId=" + caneId + ", userName=" + userName
				+ ", userAddress=" + userAddress + ", userTel=" + userTel + ", userBirth=" + userBirth + "]";
	}
	
	
}
