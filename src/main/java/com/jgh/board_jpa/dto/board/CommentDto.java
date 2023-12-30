package com.jgh.board_jpa.dto.board;


import com.jgh.board_jpa.domain.entity.Board;
import com.jgh.board_jpa.domain.entity.Comment;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private Long id;
    private String commentWriter;
    private String commentContents;

    private Long boardId;

    private LocalDateTime commentCreatedTime;

    public Comment ToEntity(Board board){
        return Comment.builder()
                .commentWriter(this.commentWriter)
                .commentContents(this.commentContents)
                .board(board)
                .build();
    }

}
