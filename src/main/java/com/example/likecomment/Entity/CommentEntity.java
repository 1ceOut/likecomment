package com.example.likecomment.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CommentId;

    @Column(name = "postingId")
    private String postingId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "rate")
    private Integer rate;

    @Column(name = "diff")
    private String diff;

    @Column(name = "comment")
    private String comment;
}