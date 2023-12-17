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


    /*
     * 게시판 목록 페이지
     * */
    @RequestMapping("/board/boardList")
    public String boardListPage(Model model){
        return "/view/board/list";
    }

    /*
     * 게시판 등록 페이지
     * */
    @RequestMapping("/board/boardInsert")
    public String boardInsertPage(Model model){
        return "view/board/form";
    }

    /*
     * 게시판 등록
     * */
    @RequestMapping("/board/boardInsertAction.do")
    public String boardInsertAction(Model model){

        return "redirect:" + "/board/boardList";
    }

    /*
    * 게시판 상세 페이지
    * */
    @RequestMapping("/board/boardDetail")
    public String boardDetailPage(Model model){
        return "view/board/detail";
    }

}
