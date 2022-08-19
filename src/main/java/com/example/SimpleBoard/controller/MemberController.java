package com.example.SimpleBoard.controller;

import com.example.SimpleBoard.domain.Member;
import com.example.SimpleBoard.dto.MemberJoinDto;
import com.example.SimpleBoard.dto.MemberLoginDto;
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
    public String join(MemberJoinDto memberJoinDto) {
        Member member = new Member(memberJoinDto.getMemberId(), memberJoinDto.getPassword(), memberJoinDto.getNickname());
        memberService.join(member);
        return "redirect:/";
    }

    @PostMapping("login")
    public String login(MemberLoginDto memberLoginDto) {
        if(memberService.login(memberLoginDto.getMemberId(), memberLoginDto.getPassword()))
            return "redirect:/";
        else
            return "redirect:/login";
    }
}
