package com.example.SimpleBoard.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 자동 추가: 기본 생성자의 접근 권한을 protected로 설정.
@Getter
@Entity(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idLogin;

    private String password;

    private String nickname;

    @Builder
    public Member(String idLogin, String password, String nickname) {
        this.idLogin = idLogin;
        this.password = password;
        this.nickname = nickname;
    }
}
