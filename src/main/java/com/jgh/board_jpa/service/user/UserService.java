package com.jgh.board_jpa.service.user;

import com.jgh.board_jpa.dto.user.UserDto;

public interface UserService {
    int userInsert(UserDto userDto)throws Exception;
}
