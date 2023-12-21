package com.jgh.board_jpa.controller;

import com.jgh.board_jpa.dto.board.BoardDto;
import com.jgh.board_jpa.service.board.BoardService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    /*
     * 게시판 목록 페이지
     * */
    @GetMapping("/boardList")
    public String boardListPage(Model model){
        log.info("======boardList=====");
        List<BoardDto> boardDtoList = boardService.findAll();
        model.addAttribute("boardList", boardDtoList);
        return "view/board/list";
    }

    /*
     * 게시판 등록 페이지
     * */
    @GetMapping("/boardInsert")
    public String boardInsertPage(Model model){
        return "view/board/insert";
    }

    /*
     * 게시판 등록 액션
     * */
    @PostMapping("/boardInsertAction.do")
    public String boardInsertAction(Model model,
                                    @ModelAttribute BoardDto boardDto){
        log.info("boardDto == "+ boardDto.ToEntity());
        boardService.save(boardDto);
        return "redirect:" + "/board/boardList";
    }

    /*
    * 게시판 상세 페이지
    * */
    @GetMapping("/boardDetail/{id}")
    public String boardDetailPage(@PathVariable Long id, Model model){

        boardService.updateHits(id);
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("boardDto", boardDto);
        return "view/board/detail";
    }


    /*
     * 게시판 수정 페이지
     * */
    @GetMapping("/boardUpdate/{id}")
    public String boardUpdatePage(@PathVariable Long id, Model model){
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("boardDto", boardDto);
        return "view/board/update";
    }

    /*
     * 게시판 수정 액션
     * */
    @PostMapping("/boardUpdate")
    public String boardUpdateAction(@ModelAttribute BoardDto boardDto, Model model){
        boardService.update(boardDto);
        model.addAttribute("boardDto", boardDto);
        return "redirect:"+ "/board/boardDetail/"+boardDto.getId();
    }


    /*
     * 게시판 삭제 액션
     * */
    @GetMapping("/boardDelete/{id}")
    public String boardDeleteAction(@PathVariable Long id, Model model){
        boardService.delete(id);
        return "redirect:" + "/board/boardList";
    }

}
