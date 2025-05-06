package com.blog.mypage.controller;

import com.blog.member.vo.MemberVo;
import com.blog.mypage.record.MyInfoRecord;
import com.blog.mypage.service.MyPageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.awt.SystemColor.info;

@RestController
@RequestMapping("/mypage")
public class MyPageController {

    @Autowired
    private MyPageService service;

    //내 정보 조회하기
    @GetMapping("/info")
    public ResponseEntity<MyInfoRecord> getMyInfo(HttpSession session){
        // 1) 세션에서 MemberVo 꺼내기
        MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
        if (loginMember == null) {
            return ResponseEntity.status(401).build();
        }
        // 2) MemberVo.getId()로 아이디 추출
        String memberId = loginMember.getId();




        MyInfoRecord info =service.getMyInfo(memberId);
        return ResponseEntity.ok(info);
    }





}//class
