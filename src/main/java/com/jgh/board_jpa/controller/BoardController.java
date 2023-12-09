package com.jgh.board_jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

    @RequestMapping("/board/list")
    public String joinPage(Model model){
        return "/view/user/list";
    }
}
