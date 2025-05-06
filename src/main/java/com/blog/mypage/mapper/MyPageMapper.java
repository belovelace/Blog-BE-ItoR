package com.blog.mypage.mapper;

import com.blog.mypage.record.MyInfoRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyPageMapper {

    //-----------조회-------------
    MyInfoRecord selectMyInfo(String memberId);







}//interface
