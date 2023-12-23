package com.jgh.board_jpa.domain.entity;

import com.jgh.board_jpa.dto.board.BoardDto;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="board_file_table")
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor     // 모든 필드를 매개변수로 하는 생성자
public class BoardFile extends Base{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String originalFileName;

    @Column
    private String storedFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    public static BoardFile ToBoardFile(Board board,
                                        String originalFileName,
                                        String storedFileName){
        return BoardFile.builder()
                .originalFileName(originalFileName)
                .storedFileName(storedFileName)
                .board(board)
                .build();

    }

}
