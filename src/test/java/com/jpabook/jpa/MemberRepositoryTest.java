package com.jpabook.jpa;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class MemberRepositoryTest {
//    @Autowired MemberRepository memberRepository;
//
//    @Test
//    @Transactional
//    public void testMember() throws Exception {
//        Member member = new Member();
//        member.setUsername("memberA");
//
//        Long saveID = memberRepository.save(member);
//
//        Member findMember = memberRepository.find(saveID);
//
//        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
//        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//
//    }


}