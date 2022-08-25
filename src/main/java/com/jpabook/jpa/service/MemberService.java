package com.jpabook.jpa.service;

import com.jpabook.jpa.domain.Member;
import com.jpabook.jpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Transactional은 보통 읽기만 있어서 다음과같이 선언
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    //injection방식 3가지
    //그중 생성자 injection -> 단축키 alt+insert
    // 이후 테스트시 확인 가능
    //RequiredArgsContructor는 final을 참조하여 생성자 injection 사용
    private final MemberRepository memberRepository;


    /*
     * 회원 가입
     */
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }

    /*
     회원 조회, readOnly는 DB에 해당 내용을 조회한다고 하는 것을 미리 알림
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findMember(Long id) {
        return memberRepository.findOne(id);
    }
}
