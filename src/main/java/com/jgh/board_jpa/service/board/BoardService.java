package com.jgh.board_jpa.service.board;

import com.jgh.board_jpa.dto.board.BoardDto;

import java.util.List;

public interface BoardService {

    void save(BoardDto boardDto);

    List<BoardDto> findAll();

    void updateHits(Long id);

    BoardDto findById(Long id);

    BoardDto update(BoardDto boardDto);
}
