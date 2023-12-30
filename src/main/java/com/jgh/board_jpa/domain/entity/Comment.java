package com.jgh.board_jpa.domain.entity;

import com.jgh.board_jpa.dto.board.CommentDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "comment_table")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor     // 모든 필드를 매개변수로 하는 생성자
public class Comment extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String commentWriter;

    @Column
    private String commentContents;

    /*Board: Comment, 1 : N */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    public CommentDto ToCommentDto(Comment comment, Long boardId){
        return CommentDto.builder()
                .id(comment.getId())
                .commentWriter(comment.getCommentWriter())
                .commentContents(comment.getCommentContents())
                .commentCreatedTime(comment.getCreatedTime())
                .boardId(boardId)
                .build();
    }

}
