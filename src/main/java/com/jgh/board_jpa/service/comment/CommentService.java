package com.jgh.board_jpa.service.comment;

import com.jgh.board_jpa.dto.board.BoardDto;
import com.jgh.board_jpa.dto.board.CommentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;

public interface CommentService {

    public Long save(CommentDto commentDto);

    List<CommentDto> findAll(Long boardId);
}
