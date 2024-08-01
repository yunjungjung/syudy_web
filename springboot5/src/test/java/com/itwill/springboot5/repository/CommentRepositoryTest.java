package com.itwill.springboot5.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot5.domain.Comment;
import com.itwill.springboot5.domain.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class CommentRepositoryTest {

	@Autowired
	private CommentRepository commentRepo;
	
	//@Test
	public void testDependencyInjection() {
		assertThat(commentRepo).isNotNull();
		log.info("commentRepo={}", commentRepo);
	}
	
	
//	@Test
	public void testFindAll() {
		List<Comment> list = commentRepo.findAll();
		assertThat(list.size()).isEqualTo(0);
		
        list.forEach(System.out::println); // (x) -> System.out.println(x)
	}
	
	@Test
	public void testSave() {
		Comment entity = Comment.builder()
				.post(Post.builder().id(40L).build())
				.ctext("테스트")
				.writer("admin").build();
		
		log.info("save 전: {}", entity);
		log.info("postId= {}", entity.getPost().getId());
		
		commentRepo.save(entity);
		log.info("save 후: {}", entity);
		
	
	}
}
