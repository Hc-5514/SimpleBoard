package com.example.SimpleBoard.service;

import com.example.SimpleBoard.domain.Member;
import com.example.SimpleBoard.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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
        validateDuplicateIdLogin(member);
        validateDuplicateMemberNickname(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateIdLogin(Member member) {
        memberRepository.findByIdLogin(member.getIdLogin()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        });
    }

    private void validateDuplicateMemberNickname(Member member) {
        memberRepository.findByNickname(member.getNickname()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 닉네임입니다.");
        });
    }

    /**
     * 로그인
     */
    public Boolean login(String loginId, String loginPw) {

        Optional<Member> result = memberRepository.findByIdLogin(loginId);
        Member resultMember;
        if (result.isPresent()) {
            resultMember = result.get();
        } else {
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }

//        Member resultMember = memberRepository.findByMember_id(loginId).get();

//        if (resultMember.equals(temp))
//            return false;

        if (!resultMember.getPassword().equals(loginPw))
            return false;

        return true;
    }
}
