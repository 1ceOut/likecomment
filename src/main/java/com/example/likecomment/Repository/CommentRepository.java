package com.example.likecomment.Repository;

import com.example.likecomment.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    Optional<CommentEntity> findByPostingId(String postingId);

    List<CommentEntity> findByUserId(String userId);

    List<CommentEntity> findCommentsByPostingId(String postingId);
}
