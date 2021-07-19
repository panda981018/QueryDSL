package com.example.querydsl.queryrepo;

import com.example.querydsl.model.MemberEntity;
import com.example.querydsl.model.QMemberEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@RequiredArgsConstructor
@Repository
public class MemberQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public MemberEntity findUser(String email, String password) throws SQLException {

        return jpaQueryFactory.selectFrom(QMemberEntity.memberEntity)
                .where(QMemberEntity.memberEntity.email.eq(email))
                .where(QMemberEntity.memberEntity.password.eq(password))
                .fetchOne();
    }

}
