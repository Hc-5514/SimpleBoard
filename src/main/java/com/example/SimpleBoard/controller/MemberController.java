package com.example.SimpleBoard.controller;

import com.example.SimpleBoard.domain.Member;
import com.example.SimpleBoard.dto.MemberDto;
import com.example.SimpleBoard.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("join")
    public String join(MemberDto memberDto) {
        Member member = new Member(memberDto.getMemberId(), memberDto.getPassword(), memberDto.getNickname());
        memberService.join(member);
        return "redirect:/";
    }
}
