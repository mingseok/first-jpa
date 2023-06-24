package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        System.out.println(form.toString()); // 클라이언트 데이터

        // 1. DTO를 변환
        Article article = form.toEntity();
        System.out.println(article.toString()); // 엔티티로 변환

        // 2. Repository에게 Entity를 DB안에 저장하게 한다
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString()); // DB 저장

        return "";
    }
}