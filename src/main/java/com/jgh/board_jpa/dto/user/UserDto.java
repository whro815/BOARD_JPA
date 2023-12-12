package com.jgh.board_jpa.dto.user;


import com.jgh.board_jpa.domain.dao.UserDao;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {

    private Long userSeqNo;
    private String username;
    private String password;

    @Builder
    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDao ToEntity(){
        return UserDao.builder()
                .username(this.username)
                .password(this.password)
                .build();
    }

}
