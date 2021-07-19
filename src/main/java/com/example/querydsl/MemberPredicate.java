package com.example.querydsl;

import com.example.querydsl.model.QMemberEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;


public class MemberPredicate {

    public static Predicate correctUser(String email, String password){
        QMemberEntity memberEntity = QMemberEntity.memberEntity;

        BooleanBuilder builder = new BooleanBuilder();

        if(email != null){
            builder.and(memberEntity.email.eq(email));
        }
        if(password != null) {
            builder.and(memberEntity.password.eq(password));
        }

        return builder;
    }


}
