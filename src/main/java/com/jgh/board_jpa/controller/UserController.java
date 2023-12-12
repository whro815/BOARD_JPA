package com.jgh.board_jpa.controller;

import com.jgh.board_jpa.dto.user.UserDto;
import com.jgh.board_jpa.service.user.UserService;
import jakarta.annotation.Resource;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/join", method = RequestMethod.GET)
    public String joinPage(Model model){
        return "/view/user/join";
    }

    @RequestMapping(value = "/user/joinAction.do", method = RequestMethod.POST)
    public String joinAction(Model model
            , RedirectAttributes redirectAttributes
            , UserDto userDto)throws Exception{

//        String msg = "등록됬습니다.";
            log.debug("username"+ userDto.getUsername());
            log.debug("password"+ userDto.getPassword());
            userService.userInsert(userDto);

//        redirectAttributes.addFlashAttribute(msg,"등록완료");

        return "redirect:" + "/user/login";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String loginPage(Model model){
        return "/view/user/login";
    }

    @RequestMapping(value = "/user/loginAction.do", method = RequestMethod.POST)
    public String loginAction(Model model){
        return "redirect:" + "/board/list";
    }

}
