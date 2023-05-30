package com.smhrd.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.iot.domain.UserAndroidInfo;
import com.smhrd.iot.domain.UserInfo;
import com.smhrd.iot.mapper.AndroidMapper;

@Service
public class AndroidService {
	
@Autowired
private AndroidMapper mapper;
	
public UserInfo userAndroidJoin(UserInfo uInfo) {
	System.out.println(uInfo.getCaneId());
	mapper.userAndroidJoin(uInfo);
	return uInfo;
}

public UserAndroidInfo userAndroidLogin(UserAndroidInfo userInfoLogin) {
    int result = mapper.userAndroidLogin(userInfoLogin);
    if (result == 1) { // 로그인 성공
        return userInfoLogin;
    } else { // 로그인 실패
        return null;
    }
}
	
}
