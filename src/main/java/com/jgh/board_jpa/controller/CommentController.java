package com.jgh.board_jpa.controller;

import com.jgh.board_jpa.dto.board.CommentDto;
import com.jgh.board_jpa.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/save")
    public ResponseEntity save(@ModelAttribute CommentDto commentDto) {
        System.out.println("commentDto=" + commentDto);

        Long saveResult = commentService.save(commentDto);
        if(saveResult != null){
            // 작성 성공 -> 댓글 목록 리턴
            // 댓글목록 : 해당 게시글의 댓글 전체 리턴
            List<CommentDto> commentDtoList = commentService.findAll(commentDto.getBoardId());
            return new ResponseEntity<>(commentDtoList, HttpStatus.OK);
        } else{
            return new ResponseEntity<>("해당 게시글이 존재하지 않습니다."
                    , HttpStatus.NOT_FOUND);
        }
    }

}
