package com.example.querydsl;

import com.example.querydsl.model.Post;
import com.example.querydsl.repo.PostQueryRepository;
import com.example.querydsl.repo.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class QuerydslApplicationTests {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostQueryRepository postQueryRepository;

    @Test
    public void findByTitle() {
        postRepository.saveAll(Arrays.asList(
                new Post("test1", "contents1"),
                new Post("test2", "contents2"),
                new Post("test3", "contents3"),
                new Post("title1", "contents"),
                new Post("title2", "contents"),
                new Post("title3", "contents")
                )
        );

        final List<Post> posts = postQueryRepository.findByTitle("test1");

        assertAll(
                () -> assertThat(posts).hasSize(1),
                () -> assertThat(posts.get(0).getTitle()).isEqualTo("test1")
        );
    }
}
