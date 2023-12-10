package com.jgh.board_jpa.controller;

import com.jgh.board_jpa.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private UserService userService;

    @RequestMapping("/user/join")
    public String joinPage(Model model){

        return "/view/user/join";
    }
}
