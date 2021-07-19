package com.example.querydsl.service;

import com.example.querydsl.model.MemberEntity;
import com.example.querydsl.queryrepo.MemberQueryRepository;
import com.example.querydsl.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MemberService {

//    // QueryDSLConfig 에서 빈으로 등록했는데 어떻게 쓰는지 몰라서 여기에 다시 한번 씀.
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
//    //

    @Autowired
    MemberQueryRepository memberQueryRepository;

    @Autowired
    MemberRepository memberRepository;

    // 유저가 맞는지 확인하기
    public MemberEntity getUser(String email, String password) throws SQLException {
        return memberQueryRepository.findUser(email, password);
    }

    // 회원가입 로직
    @Transactional
    public Long joinUs(MemberEntity memberEntity) {
        // 현재 시간
        LocalDateTime now = LocalDateTime.now();
        // HH = 24시간 포맷, hh = 12시간 포맷
        String time = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        memberEntity.setCreateDate(time);

        return memberRepository.save(MemberEntity.builder()
                .email(memberEntity.getEmail())
                .password(memberEntity.getPassword())
                .createDate(memberEntity.getCreateDate())
                .build()).getId();
    }
}
