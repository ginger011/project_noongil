package com.smhrd.iot.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.iot.domain.Report;
import com.smhrd.iot.domain.UserAndroidInfo;
import com.smhrd.iot.domain.UserInfo;

@Mapper
public interface AndroidMapper {
		public String userAndroidJoin(UserInfo uInfo);
		public int userAndroidLogin(UserAndroidInfo userInfoLogin);
		public Report userAppReport(Report report);
	
}
