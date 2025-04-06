package com.blog.kakaologin.service;


import com.blog.kakaologin.util.KakaoLoginUtil;
import com.blog.member.service.MemberService;
import com.blog.member.vo.MemberVo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

@Service //스프링이 인식하는 서비스 계층
public class KakaoLoginService {

    @Autowired
    private MemberService memberService;


    public String kakaoLogin(String code) {

        try {
            //1) 인가코드로 액세스 토큰 요청
            String accessToken = KakaoLoginUtil.getAccessToken(code);
            //2) 액세스 토큰으로 사용자 정보 요청
            JSONObject userInfo = KakaoLoginUtil.getUserInfo(accessToken);

            //3) 사용자 정보에 이메일, 닉네임 꺼내기
            String email = userInfo.getString("email");
            String nickname = userInfo.getString("nickname");

            //4) MemberVo 생성
            System.out.println("카카오 응답 nickname: " + nickname);
            System.out.println("카카오 응답 email: " + email);

            MemberVo member = new MemberVo();
            member.setId(UUID.randomUUID().toString().replace("-", ""));
            member.setEmail(email);
            member.setNick(nickname);
            member.setName(nickname);
            member.setBio(null);
            member.setPwd(null);
            member.setBirthdate(null);
            member.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            member.setActive(true);


            System.out.println(">> 최종 insert 대상 VO = " + member);

            //5) DB 저장 또는 기존 회원이면 패스
            if (!memberService.existsByEmail(email)) {
                memberService.insertMember(member);
            }
            return "로그인 성공! 닉네임: " + nickname + ", 이메일: " + email;

        } catch (Exception e) {
            e.printStackTrace(); //에러 로그 찍고 예외 메세지 전달
            return "로그인 실패: " + e.getMessage();
        }


    }


}//class
