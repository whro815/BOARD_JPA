package com.jgh.board_jpa.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass   //공통 매핑 정보가 필요할때, 부모 클래스에 선언하고, 속성만 상속받아 사용할때
@EntityListeners(AuditingEntityListener.class)  // JPA Entity에서 이벤트 발생할때마다 특정 로직을 실행
@Getter
public class Base {

    @CreationTimestamp          // 생성될때 시간을 만들어줌
    @Column(updatable = false)  // update 시에는 동작 X
    private LocalDateTime createdTime;

    @UpdateTimestamp             // 수정될때 시간을 만들어줌
    @Column(insertable = false)  // insert 시에는 동작 X
    private LocalDateTime updatedTime;

}

