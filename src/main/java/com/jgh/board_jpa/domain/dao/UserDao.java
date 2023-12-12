package com.jgh.board_jpa.domain.dao;


import jakarta.persistence.*;
import lombok.*;

@Entity(name="user_dao")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDao {

    @Id
    @Column(name = "userSeqNo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeqNo;

    @Column(name = "userName")
    private String username;

    @Column(name = "password")
    private String password;

    @Builder
    public UserDao(String username, String password) {
        this.username = username;
        this.password = password;
    }



}
