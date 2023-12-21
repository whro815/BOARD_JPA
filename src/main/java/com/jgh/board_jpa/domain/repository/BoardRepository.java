package com.jgh.board_jpa.domain.repository;

import com.jgh.board_jpa.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long> {

    //@Query(value="update Board b set b.board_hits=b.board_hits+1 where b.id=:id", nativeQuery = true)
    @Modifying
    @Query(value="update board_table set board_hits=board_hits+1 where id=?", nativeQuery = true)
    void updateHits(@Param("id")Long id);

}
