package com.jgh.board_jpa.domain.entity;

import com.jgh.board_jpa.dto.board.BoardDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name="board_table")
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public BoardDto ToBoardDto(Board board){   // dto 에게
        return BoardDto.builder()
                .id(board.getId())
                .boardWriter(board.getBoardWriter())
                .boardPass(board.getBoardPass())
                .boardTitle(board.getBoardTitle())
                .boardContents(board.getBoardContents())
                .boardHits(board.getBoardHits())
                .boardCreatedTime(board.getCreatedTime())
                .boardUpdatedTime(board.getUpdatedTime())
                .build();
    }

}
