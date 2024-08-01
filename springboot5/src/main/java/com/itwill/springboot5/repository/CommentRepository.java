package com.itwill.springboot5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.springboot5.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	// CommentRepository의 crud 기능을 단위 테스트.
	
	
}