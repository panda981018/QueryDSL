package com.example.querydsl.repo;

import com.example.querydsl.model.MemberEntity;
import com.example.querydsl.model.QMemberEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public MemberEntity findUser(String email, String password) {
        return jpaQueryFactory.selectFrom(QMemberEntity.memberEntity)
                .where(QMemberEntity.memberEntity.email.eq(email))
                .where(QMemberEntity.memberEntity.password.eq(password))
                .fetchOne();

    }
}
