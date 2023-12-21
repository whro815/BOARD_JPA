package com.jgh.board_jpa.domain.entity;

import com.jgh.board_jpa.dto.board.BoardDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name="board_table")
@Table
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor     // 모든 필드를 매개변수로 하는 생성자
public class Board extends Base{

    @Id     // pk 컬럼
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(length = 20, nullable = false)
    private String boardWriter;

    @Column
    private String boardPass;

    @Column // 255 , null 가능
    private String boardTitle;

    @Column(length = 4000)
    private String boardContents;

    @Column
    private int boardHits;

    public Board(Long id) {
        this.id = id;           // 생성자 id 만들지 않을 경우 -> 아래 빌더에서 board.id 에러 원인 못찾음.
    }

    public BoardDto ToBoardDto(Board board){   // dto 에게

        return BoardDto.builder()
                .id(this.id)
                .boardWriter(board.getBoardWriter())
                .boardPass(board.getBoardPass())
                .boardTitle(board.getBoardTitle())
                .boardContents(board.getBoardContents())
                .boardHits(board.getBoardHits())
                .boardCreatedTime(board.getCreatedTime())
                .boardUpdatedTime(board.getUpdatedTime())
                .build();
    }
    /*@Column(name = "insertUser", nullable = false)
    private Long insertUser;

    @Temporal(TemporalType.DATE)
    private Date boardDt;*/

   /* @Builder
    public Board(String boardWriter
                , String boardPass, String boardTitle
                , String boardContents, int boardHits) {
                    this.boardWriter = boardWriter;
                    this.boardPass = boardPass;
                    this.boardTitle = boardTitle;
                    this.boardContents = boardContents;
                    this.boardHits = boardHits;
    }

    public Board ToEntity(){
        return Board.builder()
                .boardWriter(this.boardWriter)
                .boardTitle(this.boardTitle)
                .boardContents(this.boardContents)
                .boardPass(this.boardPass)
                .boardHits(0)
                .build();
    }*/


}
