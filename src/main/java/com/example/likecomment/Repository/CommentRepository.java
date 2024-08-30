package com.example.likecomment.Repository;

import com.example.likecomment.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByPostingId(String postingId);

    List<CommentEntity> findByUserId(String userId);
}
