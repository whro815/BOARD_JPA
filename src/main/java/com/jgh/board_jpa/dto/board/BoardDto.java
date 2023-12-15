package com.jgh.board_jpa.dto.board;

import com.jgh.board_jpa.domain.dao.BoardDao;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@NoArgsConstructor
public class BoardDto {

    private Long boardSeqNo;
    private String boardTitle;
    private String boardContents;
    private String boardDt;

    @Builder
    public BoardDto(Long boardSeqNo, String boardTitle, String boardContents, String boardDt) {
        this.boardSeqNo = boardSeqNo;
        this.boardTitle = boardTitle;
        this.boardContents = boardContents;
        this.boardDt = boardDt;
    }

    public BoardDao ToEntity(){
        return BoardDao.builder()
                .boardTitle(boardTitle)
                .boardContents(boardContents)
                .build();
    }

}
