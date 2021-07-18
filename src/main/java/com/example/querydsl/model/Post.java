package com.example.querydsl.model;

import lombok.*;

import javax.persistence.*;

@SequenceGenerator(
        name = "ID_GEN",
        sequenceName = "SEQ_ID_GEN",
        allocationSize = 1
)
@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "ID_GEN")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Builder
    public Post(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
