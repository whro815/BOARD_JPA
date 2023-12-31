package com.jgh.board_jpa.controller;

import com.jgh.board_jpa.domain.entity.Board;
import com.jgh.board_jpa.dto.board.BoardDto;
import com.jgh.board_jpa.dto.board.CommentDto;
import com.jgh.board_jpa.service.board.BoardService;
import com.jgh.board_jpa.service.comment.CommentService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    private final CommentService commentService;

    /*
     * 게시판 목록 페이지
     * */
    @GetMapping("/list")
    public String boardListPage(Model model){
        log.info("======list=====");
        List<BoardDto> boardDtoList = boardService.findAll();
        model.addAttribute("boardList", boardDtoList);
        return "view/board/list";
    }

    /*
     * 게시판 등록 페이지
     * */
    @GetMapping("/insert")
    public String boardInsertPage(Model model){
        return "view/board/insert";
    }

    /*
     * 게시판 등록 액션
     * */
    @PostMapping("/insert")
    public String boardInsertAction(Model model,
                                    @ModelAttribute BoardDto boardDto) throws IOException {
        log.info("insert == "+ boardDto.ToEntity());
        boardService.save(boardDto);
        return "redirect:" + "/board/list";
    }

    /*
    * 게시판 상세 페이지
    * */
    @GetMapping("/detail/{id}")
    public String boardDetailPage(@PathVariable Long id, Model model,
                                  @PageableDefault(page=1) Pageable pageable){

        boardService.updateHits(id);
        BoardDto boardDto = boardService.findById(id);
        List<CommentDto> commentList = commentService.findAll(id);

        model.addAttribute("commentList", commentList);
        model.addAttribute("boardDto", boardDto);
        model.addAttribute("page", pageable.getPageNumber());
        return "view/board/detail";
    }


    /*
     * 게시판 수정 페이지
     * */
    @GetMapping("/update/{id}")
    public String boardUpdatePage(@PathVariable Long id, Model model){
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("boardDto", boardDto);
        return "view/board/update";
    }

    /*
     * 게시판 수정 액션
     * */
    @PostMapping("/update")
    public String boardUpdateAction(@ModelAttribute BoardDto boardDto, Model model){
        boardService.update(boardDto);
        model.addAttribute("boardDto", boardDto);
        return "redirect:"+ "/board/detail/"+boardDto.getId();
    }


    /*
     * 게시판 삭제 액션
     * */
    @GetMapping("/delete/{id}")
    public String boardDeleteAction(@PathVariable Long id, Model model){
        boardService.delete(id);
        return "redirect:" + "/board/list";
    }

    // board/paging?page=1
    @GetMapping("/paging")
    public String paging(@PageableDefault(page = 1) Pageable pageable, Model model){

        // 게시글 14
        // - 한페이지에 5개씩 - > 3개
        // - 한페이지에 3개씩 -> 5개
        pageable.getPageNumber();
        Page<BoardDto> boardList = boardService.paging(pageable);

        int blockLimit = 3;
        int startPage = (((int)(Math.ceil((double)pageable.getPageNumber() / blockLimit))) - 1) * blockLimit + 1; // 1 4 7 10 ~~
        int endPage = ((startPage + blockLimit - 1) < boardList.getTotalPages()) ? startPage + blockLimit - 1 : boardList.getTotalPages();

        // page 갯수 20개
        // 현재 사용자가 3페이지
        // 1 2 3
        // 현재 사용자가 7페이지
        // 7 8 9
        // 보여지는 페이지 갯수 3개
        // 총 페이지 갯수 8개

        model.addAttribute("boardList", boardList);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "view/board/paging";
    }

}
