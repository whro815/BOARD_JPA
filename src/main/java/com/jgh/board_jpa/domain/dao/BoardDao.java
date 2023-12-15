package com.jgh.board_jpa.domain.dao;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name="board_dao")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardDao {

    @Id
    @Column(name="boardSeqNo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardSeqNo;

    @Column(length = 60,name = "boardTitle")
    private String boardTitle;

    @Column(length = 4000,name = "boardContents")
    private String boardContents;

    @Column(name = "insertUser", nullable = false)
    private Long insertUser;

    @Temporal(TemporalType.DATE)
    private Date boardDt;

    @Builder
    public BoardDao( String boardTitle, String boardContents) {
        this.boardTitle = boardTitle;
        this.boardContents = boardContents;
    }

}
