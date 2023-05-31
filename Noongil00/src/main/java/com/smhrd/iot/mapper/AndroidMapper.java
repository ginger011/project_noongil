package com.smhrd.iot.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.iot.domain.BlindCall;
import com.smhrd.iot.domain.Report;
import com.smhrd.iot.domain.UserAndroidInfo;
import com.smhrd.iot.domain.UserInfo;

@Mapper
public interface AndroidMapper {
		public String userAndroidJoin(UserInfo uInfo);
		public int userAndroidLogin(UserAndroidInfo userInfoLogin);
		public void userAppReport(Report report);
		public void androidBlindCall(BlindCall bc);
		 // 회원 정보 조회
	    public UserInfo getUserInfoByUserId(String userId);
	    // 회원 정보 수정
	    public void updateUserInfo(UserInfo updatedUserInfo);
}
