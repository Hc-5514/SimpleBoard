package com.example.SimpleBoard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class MemberJoinDto {

    private String idLogin;

    private String password;

    private String nickname;
}
