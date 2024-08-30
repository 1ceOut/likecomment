package com.example.likecomment.Service;

import com.example.likecomment.Entity.CommentEntity;
import com.example.likecomment.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public CommentEntity createComment(CommentEntity commentEntity) {
        return commentRepository.save(commentEntity);
    }

    public Optional<CommentEntity> getCommentById(Long commentId) {
        return commentRepository.findById(commentId);
    }

    public Optional<CommentEntity> updateComment(Long commentId, CommentEntity updatedComment) {
        return commentRepository.findById(commentId).map(comment -> {
            comment.setPostingId(updatedComment.getPostingId());
            comment.setUserId(updatedComment.getUserId());
            comment.setRate(updatedComment.getRate());
            comment.setDiff(updatedComment.getDiff());
            comment.setComment(updatedComment.getComment());
            comment.setCommentimg(updatedComment.getCommentimg());
            return commentRepository.save(comment);
        });
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public List<CommentEntity> getCommentsByPostingId(String postingId) {
        return commentRepository.findByPostingId(postingId);
    }

    public List<CommentEntity> getCommentsByUserId(String userId) {
        return commentRepository.findByUserId(userId);
    }
}
