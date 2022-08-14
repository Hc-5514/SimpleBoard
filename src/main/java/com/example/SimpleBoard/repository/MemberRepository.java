package com.example.SimpleBoard.repository;

import com.example.SimpleBoard.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepository implements MemberRepositoryInterface {

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
    public Optional<Member> findByMember_id(String member_id) {
        List<Member> result = em.createQuery("Select m from member m where m.member_id =: member_id", Member.class)
                .setParameter("member_id", member_id)
                .getResultList();
        return result.stream().findAny();
    }
}
