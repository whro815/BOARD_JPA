package com.jgh.board_jpa.domain.repository;

import com.jgh.board_jpa.domain.dao.BoardDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardDao, Long> {

}
