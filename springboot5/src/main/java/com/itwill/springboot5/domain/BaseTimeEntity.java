package com.itwill.springboot5.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor // 기본 생성자
@Getter // getter 메서드
@ToString // toString()
@EqualsAndHashCode // equals(), hashCode(), canEqual()
@MappedSuperclass // 다른 엔터티 클래스의 상위 클래스로 사용됨.
@EntityListeners(AuditingEntityListener.class)
//-> 엔터티 (최초) 생성시간, (최종) 수정시간 등을 자동으로 DB에 저장하기 위해서.
public class BaseTimeEntity {
    
    @CreatedDate // 엔터티 (최초) 생성시간을 저장하는 필드.
    private LocalDateTime createdTime;
    
    @LastModifiedDate // 엔터티 (최종) 수정시간을 저장하는 필드.
    private LocalDateTime modifiedTime;
}