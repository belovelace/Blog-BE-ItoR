package com.blog.mypage.service;

import com.blog.mypage.mapper.MyPageMapper;
import com.blog.mypage.record.MyInfoRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyPageService {

    @Autowired
    private MyPageMapper dao;

    public MyInfoRecord getMyInfo(String memberId){
        return dao.selectMyInfo(memberId);
    }














}//class
