package com.jgh.board_jpa.service.board.impl;

import com.jgh.board_jpa.domain.repository.BoardRepository;
import com.jgh.board_jpa.dto.board.BoardDto;
import com.jgh.board_jpa.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public void boardInsert(BoardDto boardDto) throws Exception {
        try {
            boardRepository.save(boardDto.ToEntity());
        }catch (Exception e){
            log.error("message: {}", e.getMessage());
        }
    }
}
