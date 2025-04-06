package com.blog.member.service;

import com.blog.member.mapper.MemberMapper;
import com.blog.member.vo.MemberVo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.UUID;

@Service
public class MemberService {

    @Autowired
    private MemberMapper mapper;

    @Autowired
    private ApplicationContext context;


    @PostConstruct
    public void checkMapper() {
        String[] names = context.getBeanNamesForType(MemberMapper.class);
        System.out.println(">>> 등록된 MemberMapper 빈: " + Arrays.toString(names));
    }

    public int join(MemberVo vo) {
        mapper.insertMember(vo);
        return 1; // 성공 시 1 반환 (또는 원하는 처리 결과 반환)
    }


    public boolean existsByEmail(String email){
        return mapper.selectByEmail(email) != null;
    }

    public void insertMember(MemberVo vo){

        if (vo.getId() == null || vo.getId().isEmpty()) {
            String uuid = UUID.randomUUID().toString().replace("-", "");
            vo.setId(uuid);
            System.out.println(">> 생성된 ID: " + uuid);
        }

        System.out.println(">> insert 대상 VO = " + vo);
        mapper.insertMember(vo);

    }



}//class
