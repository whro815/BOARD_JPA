package com.jgh.board_jpa.domain.dao;


import jakarta.persistence.*;
import lombok.Getter;

import lombok.Setter;

@Table
@Entity
@Setter
@Getter
public class UserDao {

    @Id
    @Column(name = "userSeqNo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeqNo;

    private String username;

    private String password;


}
