package com.jgh.board_jpa.domain.repository;

import com.jgh.board_jpa.domain.entity.Board;
import com.jgh.board_jpa.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByBoardOrderByIdDesc(Board board);
}
