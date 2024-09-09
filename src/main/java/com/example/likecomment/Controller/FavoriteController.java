package com.example.likecomment.Controller;

import com.example.likecomment.Service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/favorite")
//@CrossOrigin(origins = {"http://localhost:8080"}, allowCredentials = "true")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/toggle")
    public ResponseEntity<String> toggleFavorite(@RequestParam String postingId, @RequestParam String userId) {
        favoriteService.toggleFavorite(postingId, userId);
        return ResponseEntity.ok("Favorite toggled");
    }

    @GetMapping("/check")
    public ResponseEntity<Boolean> checkFavorite(@RequestParam String postingId, @RequestParam String userId) {
        boolean isFavorite = favoriteService.isFavorite(postingId, userId);
        return ResponseEntity.ok(isFavorite);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getFavoriteCount(@RequestParam String postingId) {
        long count = favoriteService.getFavoriteCount(postingId);
        return ResponseEntity.ok(count);
    }
}
