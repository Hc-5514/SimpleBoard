package com.example.SimpleBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String Home() {
        return "index";
    }

    @GetMapping("login")
    public String login() {
        return "member/login";
    }

    @GetMapping("join")
    public String join() {
        return "member/join";
    }
}
