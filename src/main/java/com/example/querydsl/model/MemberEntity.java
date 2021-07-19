package com.example.querydsl.model;

import lombok.*;

import javax.persistence.*;

@SequenceGenerator(
        name = "USER_SEQ_GEN",
        sequenceName = "USER_SEQ",
        allocationSize = 1
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "MEMBER")
public class MemberEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "USER_SEQ_GEN")
    private Long id;

    @Column(length = 20, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column
    private String createDate;

    @Builder
    public MemberEntity(String email, String password, String createDate) {
        this.email = email;
        this.password = password;
        this.createDate = createDate;
    }
}
