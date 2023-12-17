package com.jgh.board_jpa.domain.dao;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity(name="user_dao")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDao {

    @Id
    @Column(name = "userSeqNo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeqNo;

    @Column(length = 30)
    private String username;

    @Column(length = 40)
    private String password;

    @Temporal(TemporalType.DATE)
    private Date insertDt;

    @OneToMany
    private List<BoardDao> Boards;

    @Builder
    public UserDao(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
