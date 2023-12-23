package com.jgh.board_jpa.service.board.impl;

import com.jgh.board_jpa.domain.entity.Board;
import com.jgh.board_jpa.domain.repository.BoardRepository;
import com.jgh.board_jpa.dto.board.BoardDto;
import com.jgh.board_jpa.service.board.BoardService;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// DTO -> Entity (Entity Class)
// Entity -> DTO (DTO Class)

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    @Override
    public void save(BoardDto boardDto) {
        boardRepository.save(boardDto.ToEntity()); //매개변수를 엔티티 리턴
    }


    @Override
    public List<BoardDto> findAll() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board board: boardList){
            boardDtoList.add(board.ToBoardDto(board));
        }

        return boardDtoList;
    }

    @Transactional
    @Override
    public void updateHits(Long id) {
        boardRepository.updateHits(id); // 조회수
    }

    @Override
    public BoardDto findById(Long id) {
        Optional<Board> optionalBoard = boardRepository.findById(id);

        if(optionalBoard.isPresent()){
            Board board = optionalBoard.get();
            BoardDto boardDto = board.ToBoardDto(board);
            return boardDto;
        } else {
            return null;
        }

    }

    @Transactional
    @Override
    public BoardDto update(BoardDto boardDto) {
        boardRepository.save(boardDto.ToUpdateEntity(boardDto));
        return this.findById(boardDto.getId());
    }

    @Override
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

    @Override
    public Page<BoardDto> paging(Pageable pageable) {

        int page = pageable.getPageNumber() - 1;    // 요청한 값을 하나 빼주고
        int pageLimit = 3;                          // 한 페이지에 보여줄 글 개수

        // 한페이지당 3개씩 글을 보여주고, 정렬기준은 id 기준으로 내림차순 정렬
        // page 위치에 있는 값은 0부터 시작
        Page<Board> boardEntities =
                boardRepository.findAll(PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "id")));

        BoardDto.pageDataWrite(boardEntities);

        // 목록 : id, writer, title, hits, createdTime
        Page<BoardDto> boardDtos =
                boardEntities.map(board -> new BoardDto(board.getId()
                                            , board.getBoardWriter()
                                            , board.getBoardTitle()
                                            , board.getBoardHits()
                                            , board.getCreatedTime()));

        return boardDtos;

    }
}
