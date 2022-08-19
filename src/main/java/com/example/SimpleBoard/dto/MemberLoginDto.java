package com.example.SimpleBoard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class MemberLoginDto {

    private String memberId;

    private String password;
}
