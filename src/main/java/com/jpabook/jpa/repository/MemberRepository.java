package com.jpabook.jpa.repository;

import com.jpabook.jpa.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    // 저장하는 로직 완성
    public void save(Member member) {
        em.persist(member);
    }

    // 조회하는 로직
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    // 전체 조회
    public List<Member> findAll() {
        //JPQL 쿼리 직접 작성 , (쿼리문, 반환타입), return 과 변수 합치는 단축키 Ctrl+Alt+N
        return em.createQuery("select  m from Member m", Member.class)
                .getResultList();
    }

}
