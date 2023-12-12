package com.jgh.board_jpa.service.user;

import com.jgh.board_jpa.domain.dao.UserDao;
import com.jgh.board_jpa.dto.user.UserDto;

import java.util.List;

public interface UserService {

    void userInsert(UserDto userDto)throws Exception;

}
