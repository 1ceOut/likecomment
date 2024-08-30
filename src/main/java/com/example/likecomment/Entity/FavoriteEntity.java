package com.example.likecomment.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Favorite")
public class FavoriteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Favorite;

    @Column(name = "postingId")
    private String postingId;

    @Column(name = "user_id")
    private String userId;
}