package com.jgh.board_jpa.service.comment.impl;

import com.jgh.board_jpa.domain.entity.Board;
import com.jgh.board_jpa.domain.entity.Comment;
import com.jgh.board_jpa.domain.repository.BoardRepository;
import com.jgh.board_jpa.domain.repository.CommentRepository;
import com.jgh.board_jpa.dto.board.CommentDto;
import com.jgh.board_jpa.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final BoardRepository boardRepository;

    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public Long save(CommentDto commentDto) {
        //Comment.ToEntity(commentDto);

        /*부모 엔티티 ( Board Entity ) 조회*/
        Optional<Board> optionalBoardEntity = boardRepository.findById(commentDto.getBoardId());

        if(optionalBoardEntity.isPresent()) {
            Board boardEntity = optionalBoardEntity.get();
            Comment commentEnttity = commentDto.ToEntity(boardEntity);
            return commentRepository.save(commentEnttity).getId();
        } else {
            return null;
        }

    }

    @Override
    @Transactional
    public List<CommentDto> findAll(Long boardId) {

        Board boardEntity = boardRepository.findById(boardId).get();
        List<Comment> commentEntityList = commentRepository.findAllByBoardOrderByIdDesc(boardEntity);

        /* EntityList -> DTOlist*/
        List<CommentDto> commentDtoList = new ArrayList<>();
        
        for (Comment comment : commentEntityList) {
            commentDtoList.add(comment.ToCommentDto(comment, boardId));
        }
        
        return commentDtoList;
    }
}
