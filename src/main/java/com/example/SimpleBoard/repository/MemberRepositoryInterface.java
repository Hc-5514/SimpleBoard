package com.example.SimpleBoard.repository;

import com.example.SimpleBoard.domain.Member;

import java.util.Optional;

public interface MemberRepositoryInterface {

    Member save(Member member);

    Optional<Member> findById(Long Id);

    Optional<Member> findByIdLogin(String member_id);

    Optional<Member> findByNickname(String nickname);
}
