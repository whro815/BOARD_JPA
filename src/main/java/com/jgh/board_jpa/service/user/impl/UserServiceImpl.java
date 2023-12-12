package com.jgh.board_jpa.service.user.impl;

import com.jgh.board_jpa.domain.repository.UserRepository;
import com.jgh.board_jpa.dto.user.UserDto;
import com.jgh.board_jpa.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void userInsert(UserDto userDto)throws Exception{
        try {
            userRepository.save(userDto.ToEntity());
        }catch (Exception e){
            log.error("message: {}", e.getMessage());
        }

    }
}
