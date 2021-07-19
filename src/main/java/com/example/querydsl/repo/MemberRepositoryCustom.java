package com.example.querydsl.repo;

import com.example.querydsl.model.MemberEntity;

public interface MemberRepositoryCustom {
    MemberEntity findUser(String email, String password);
}
