package com.example.SimpleBoard.repository;

import com.example.SimpleBoard.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepository implements MemberRepositoryInterface {

    @PersistenceContext
    private final EntityManager em;

    public MemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long Id) {
        Member member = em.find(Member.class, Id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByIdLogin(String idLogin) {
        List<Member> result = em.createQuery("Select m from member m where m.idLogin=:idLogin", Member.class).setParameter("idLogin", idLogin).getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByNickname(String nickname) {
        List<Member> result = em.createQuery("Select m from member m where m.nickname=:nickname", Member.class).setParameter("nickname", nickname).getResultList();
        return result.stream().findAny();
    }
}
