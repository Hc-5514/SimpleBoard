package com.example.SimpleBoard.service;

import com.example.SimpleBoard.domain.Member;
import com.example.SimpleBoard.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MemberService {

    MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        // 아이디 및 닉네임 중복 검사
        validateDuplicateMemberId(member);
        validateDuplicateMemberNickname(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMemberId(Member member) {
        memberRepository.findByMember_id(member.getMember_id()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        });
    }

    private void validateDuplicateMemberNickname(Member member) {
        memberRepository.findByNickname(member.getNickname()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 닉네임입니다.");
        });
    }
}
