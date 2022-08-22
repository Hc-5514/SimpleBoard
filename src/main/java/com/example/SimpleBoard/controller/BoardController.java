package com.example.SimpleBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("board")
    public String BoardHome(){
        return "/board/board_main";
    }
}
