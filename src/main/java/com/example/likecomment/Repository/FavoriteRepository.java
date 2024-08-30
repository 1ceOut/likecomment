package com.example.likecomment.Repository;

import com.example.likecomment.Entity.FavoriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<FavoriteEntity, Long> {
    Optional<FavoriteEntity> findByPostingIdAndUserId(String postingId, String userId);

    long countByPostingId(String postingId);
}
