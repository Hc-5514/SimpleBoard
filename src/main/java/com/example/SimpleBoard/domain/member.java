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
@Getter // 클래스 내 모든 필드의 Getter 메소드를 자동으로 생성.
@Entity
public class member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String member_id;

    private String password;

    private String nickname;

    @Builder
    public member(String member_id, String password, String nickname){
        this.member_id = member_id;
        this.password = password;
        this.nickname = nickname;
    }
}
