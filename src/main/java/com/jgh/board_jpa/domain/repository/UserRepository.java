package com.jgh.board_jpa.domain.repository;

import com.jgh.board_jpa.domain.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDao, Long> {

}
