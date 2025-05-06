package com.blog.mypage.service;

import com.blog.mypage.mapper.MyPageMapper;
import com.blog.mypage.record.MyInfoRecord;
import com.blog.mypage.record.MyInfoUpdateRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyPageService {

    @Autowired
    private MyPageMapper mapper;

    public MyInfoRecord getMyInfo(String memberId){
        return mapper.selectMyInfo(memberId);
    }

    public void updateMyInfo(String memberId, MyInfoUpdateRecord update) {
        mapper.updateMyInfo(
                memberId,
                update.name(),
                update.nickname(),
                update.intro(),
                update.birthday()
        );
    }














}//class
