package com.jgh.board_jpa.dto.board;

import com.jgh.board_jpa.domain.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor      // 기본 생성자
@Builder
@AllArgsConstructor     // 모든 필드를 매개변수로 하는 생성자
public class BoardDto {

    private Long id;
    private String boardWriter;     //작성자
    private String boardTitle;      //게시판 제목
    private String boardContents;   //게시판 내용
    private String boardPass;       //비밀번호
    private int boardHits;          //게시판 조회

    private LocalDateTime boardCreatedTime;  // 게시판 생성 시간
    private LocalDateTime boardUpdatedTime;  // 게시판 수정 시간


    public BoardDto(Long id){
        this.id = id;
    }

/*    @Builder
    public BoardDto(Long id, String boardWriter,
                    String boardTitle, String boardContents,
                    String boardPass, int boardHits,
                    LocalDateTime boardCreateTime, LocalDateTime boardUpdateTime) {
        this.id = id;
        this.boardWriter = boardWriter;
        this.boardTitle = boardTitle;
        this.boardContents = boardContents;
        this.boardPass = boardPass;
        this.boardHits = boardHits;
        this.boardCreateTime = boardCreateTime;
        this.boardUpdateTime = boardUpdateTime;
    }*/

    public Board ToEntity(){        // 엔티티에게
        return Board.builder()
                .boardWriter(this.boardWriter)
                .boardTitle(this.boardTitle)
                .boardContents(this.boardContents)
                .boardPass(this.boardPass)
                .boardHits(0)
                .build();
    }

    public Board ToUpdateEntity(){        // 엔티티에게
        return Board.builder()
                .id(BoardDto.builder().id)
                .boardWriter(this.boardWriter)
                .boardTitle(this.boardTitle)
                .boardContents(this.boardContents)
                .boardPass(this.boardPass)
                .boardHits(0)
                .build();
    }

    /* @Builder
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
    }*/

}
