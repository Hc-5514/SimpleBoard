package com.example.SimpleBoard.service;

import com.example.SimpleBoard.domain.Member;
import com.example.SimpleBoard.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

    @BeforeEach
    public void BeforeEach() {
        memberRepository = new MemberRepository(em);
        memberService = new MemberService(memberRepository);
    }

    @Test
    void 회원가입() {

        // given
        Member member = new Member("테스트", "Test1", "닉네임");

        // when
        Long resultId = memberService.join(member);

        // then
        Member resultMember = memberRepository.findById(resultId).get();
        Assertions.assertThat(member.getMember_id()).isEqualTo(resultMember.getMember_id());
    }

    @Test
    void 중복_아이디_예외() {

        // given
        Member member = new Member("테스트", "Test1", "닉네임");
        Member member2 = new Member("테스트", "Test1", "닉네임2");

        // when
        memberService.join(member);

        // then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 아이디입니다.");
    }

    @Test
    void 중복_닉네임_예외() {

        // given
        Member member = new Member("테스트", "Test1", "닉네임");
        Member member2 = new Member("테스트2", "Test1", "닉네임");

        // when
        memberService.join(member);

        // then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 닉네임입니다.");
    }
}