package com.jgh.board_jpa.service.user.impl;

import com.jgh.board_jpa.domain.repository.UserRepository;
import com.jgh.board_jpa.dto.user.UserDto;
import com.jgh.board_jpa.service.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public int userInsert(UserDto userDto) throws Exception {
        int data = 0;
        //int data = userRepository
        return data;
    }
}
