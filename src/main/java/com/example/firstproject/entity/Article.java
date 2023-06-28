package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@ToString
@Getter
public class Article {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // 괄호까지 작성해줘야 db가 id를 자동생성하게 된다
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    protected Article() {}

    public void patch(Article article) {
        if (article.title != null) {
            this.title = article.title;
        }

        if (article.content != null) {
            this.content = article.content;
        }
    }
}