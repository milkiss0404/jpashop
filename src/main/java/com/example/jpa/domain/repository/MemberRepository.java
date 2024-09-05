package com.example.jpa.domain.repository;

import com.example.jpa.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;
//    @PersistenceUnit //엔티티매니저팩토리 주입!!
//    private EntityManagerFactory emf;


    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class,id);
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class) //jpql은 객체에대한 쿼리 임 테이블이아님
                .getResultList();
    }

    public List<Member> finByName(String name){
        return em.createQuery("select m from Member  m where m.name = :name",Member.class)
                .setParameter("name",name)
                .getResultList();
    }

}
