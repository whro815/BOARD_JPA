package com.jgh.board_jpa.domain.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;


public class UserDao {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userSeqNo;
    private String boardTitle;

}
