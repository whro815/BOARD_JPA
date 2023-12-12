package com.jgh.board_jpa.service.user.impl;

import com.jgh.board_jpa.domain.dao.UserDao;
import com.jgh.board_jpa.domain.repository.UserRepository;
import com.jgh.board_jpa.dto.user.UserDto;
import com.jgh.board_jpa.service.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public void userInsert(UserDto userDto) throws Exception {
        userRepository.save(userDto.ToEntity());
    }
}
