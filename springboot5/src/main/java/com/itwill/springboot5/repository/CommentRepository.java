package com.itwill.springboot5.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.springboot5.domain.Comment;
import com.itwill.springboot5.domain.Post;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	// CommentRepository의 crud 기능을 단위 테스트.
	
	// JPA query method:
	Page<Comment> findByPostId(Long id, Pageable pageable);
	Page<Comment> findByPost(Post post, Pageable pageable);
}