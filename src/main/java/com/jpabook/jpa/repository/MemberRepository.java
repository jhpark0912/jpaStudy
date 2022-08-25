package com.jpabook.jpa.repository;

import com.jpabook.jpa.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//@Respository는 bean으로 등록 진행 내부에 component존재하며 springboot에서 스캔하여 등록
@Repository
@RequiredArgsConstructor
public class MemberRepository {

    //EntityManager를 spring boot가 직접 주입
    //생성자를 @PersistenceContext 가 지원하지만 Spring boot가 autowired를 이용(Spring-data-jpa에서 지원)
    private final EntityManager em;

    // 저장하는 로직 완성
    public void save(Member member) {
        em.persist(member);
    }

    // 조회하는 로직, type과 parameter 주입
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    // 전체 조회
    public List<Member> findAll() {
        //JPQL 쿼리 직접 작성 , (쿼리문, 반환타입), return 과 변수 합치는 단축키 Ctrl+Alt+N
        //JPQL 과 SQL 차이는 Entity를 대상으로 조회
        return em.createQuery("select  m from Member m", Member.class)
                .getResultList();
    }

    // 이름 검색
    public List<Member> findByName(String name) {
        //parameter setting
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}
