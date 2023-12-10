package com.jgh.board_jpa.dto.user;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {

    private Long userSeqNo;
    private String username;
    private String password;


}
