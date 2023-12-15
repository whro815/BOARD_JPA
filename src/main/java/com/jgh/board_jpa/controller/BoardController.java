package com.jgh.board_jpa.controller;

import com.jgh.board_jpa.service.board.BoardService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/board/boardList")
    public String boardListPage(Model model){
        return "/view/board/list";
    }

    @RequestMapping("/board/boardInsert")
    public String boardInsertPage(Model model){
        return "view/board/form";
    }

    @RequestMapping("/board/boardInsertAction.do")
    public String boardInsertAction(Model model){

        return "redirect:" + "/board/boardList";
    }
}
