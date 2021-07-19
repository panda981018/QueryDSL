package com.example.querydsl.repo;

import com.example.querydsl.model.MemberEntity;
import com.example.querydsl.model.QMemberEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public MemberRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(MemberEntity.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public MemberEntity findUser(String email, String password) {
        return jpaQueryFactory.selectFrom(QMemberEntity.memberEntity)
                .where(QMemberEntity.memberEntity.email.eq(email))
                .where(QMemberEntity.memberEntity.password.eq(password))
                .fetchOne();
    }
}
