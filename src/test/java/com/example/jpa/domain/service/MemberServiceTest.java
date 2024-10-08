package com.example.jpa.domain.service;

import com.example.jpa.domain.Member;
import com.example.jpa.domain.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    @Rollback(false)
    public void 회원가입() throws Exception{
        Member member = new Member();
        member.setName("kim");

        Long saveId = memberService.join(member);

        assertEquals(member,memberRepository.findOne(saveId));

    }

    @Test
    public void 중복_회원_제외() throws Exception{
    Member member1 = new Member();
    Member member2= new Member();
    member1.setName("kim");
    member2.setName("kim");

    memberService.join(member1);
    memberService.join(member2);



    }

}