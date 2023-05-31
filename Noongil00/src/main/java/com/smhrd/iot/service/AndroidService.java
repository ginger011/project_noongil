package com.smhrd.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.iot.domain.BlindCall;
import com.smhrd.iot.domain.Report;
import com.smhrd.iot.domain.UserAndroidInfo;
import com.smhrd.iot.domain.UserInfo;
import com.smhrd.iot.mapper.AndroidMapper;

@Service
public class AndroidService {

    @Autowired
    private AndroidMapper mapper;

    // 회원가입
    public void userAndroidJoin(UserInfo uInfo) {
        System.out.println(uInfo.getCaneId());
        mapper.userAndroidJoin(uInfo);
    }

    // 회원 신고
    public Report userAppReport(Report report) {
        mapper.userAppReport(report);
        return report;
    }

    // 세빛콜
    public BlindCall androidBlindCall(BlindCall bc) {
        mapper.androidBlindCall(bc);
        return bc;
    }

    // 회원 정보 조회
    public UserInfo getUserInfoByUserId(String userId) {
        return mapper.getUserInfoByUserId(userId);
    }

    // 회원 정보 수정
    public void updateUserInfo(UserInfo updatedUserInfo) {
        mapper.updateUserInfo(updatedUserInfo);
    }

    // 로그인
    public UserAndroidInfo userAndroidLogin(UserAndroidInfo userInfoLogin) {
        int result = mapper.userAndroidLogin(userInfoLogin);
        if (result == 1) { // 로그인 성공
            return userInfoLogin;
        } else { // 로그인 실패
            return null;
        }
}
    }