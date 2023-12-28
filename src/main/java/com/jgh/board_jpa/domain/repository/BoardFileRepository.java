package com.jgh.board_jpa.domain.repository;

import com.jgh.board_jpa.domain.entity.BoardFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardFileRepository extends JpaRepository<BoardFile, Long> {

}
