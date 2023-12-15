package com.jgh.board_jpa.service.board;

import com.jgh.board_jpa.domain.dao.UserDao;
import com.jgh.board_jpa.dto.board.BoardDto;
import com.jgh.board_jpa.dto.user.UserDto;

import java.util.List;

public interface BoardService {

    void boardInsert(BoardDto boardDto)throws Exception;

}
