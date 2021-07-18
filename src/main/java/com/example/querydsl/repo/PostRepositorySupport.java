//package com.example.querydsl.repo;
//
//import com.example.querydsl.model.Post;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//import static com.example.querydsl.model.QPost.post;
//
//@Repository
//public class PostRepositorySupport extends QuerydslRepositorySupport {
//
//    private final JPAQueryFactory jpaQueryFactory;
//
//    public PostRepositorySupport(final JPAQueryFactory jpaQueryFactory) {
//        super(Post.class);
//        this.jpaQueryFactory = jpaQueryFactory;
//    }
//
//    public List<Post> findByTitle(final String title) {
//        return jpaQueryFactory.selectFrom(post)
//                .where(post.title.eq(title))
//                .fetch();
//    }
//}
