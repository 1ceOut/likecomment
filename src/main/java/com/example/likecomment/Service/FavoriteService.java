package com.example.likecomment.Service;

import com.example.likecomment.Entity.FavoriteEntity;
import com.example.likecomment.Repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    public void toggleFavorite(String postingId, String userId) {
        Optional<FavoriteEntity> existingFavorite = favoriteRepository.findByPostingIdAndUserId(postingId, userId);
        if (existingFavorite.isPresent()) {
            favoriteRepository.delete(existingFavorite.get());
        } else {
            FavoriteEntity favoriteEntity = new FavoriteEntity();
            favoriteEntity.setPostingId(postingId);
            favoriteEntity.setUserId(userId);
            favoriteRepository.save(favoriteEntity);
        }
    }

    public boolean isFavorite(String postingId, String userId) {
        return favoriteRepository.findByPostingIdAndUserId(postingId, userId).isPresent();
    }

    public long getFavoriteCount(String postingId) {
        return favoriteRepository.countByPostingId(postingId);
    }
}
