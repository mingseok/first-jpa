package com.example.firstproject.repository;

import com.example.firstproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// 기존, Crud보다 페이징 처리같은 기능이 더 많은것을 말한다.
public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 특정 게시글의 모든 댓글 조회
    @Query(value = "select * from comment where article_id = :articleId", nativeQuery = true)
    List<Comment> findByArticleId(Long articleId);

    // 특정 닉네임의 모든 댓글 조회
    List<Comment> findByNickname(String nickname);

}