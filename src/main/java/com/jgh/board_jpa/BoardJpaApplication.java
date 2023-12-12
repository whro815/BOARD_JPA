package com.jgh.board_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@SpringBootApplication
public class BoardJpaApplication {

    public static void main(String[] args){
        SpringApplication.run(BoardJpaApplication.class, args);
    }

}
