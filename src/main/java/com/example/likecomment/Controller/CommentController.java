package com.example.likecomment.Controller;

import com.example.likecomment.Entity.CommentEntity;
import com.example.likecomment.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
//@CrossOrigin(origins = {"http://localhost:8080", "https://api.icebuckwheat.kro.kr"}, allowCredentials = "true")
public class CommentController {

    @Autowired
    private CommentService commentService;

    //댓글 만들기
    @PostMapping
    public ResponseEntity<CommentEntity> createComment(@RequestBody CommentEntity commentEntity) {
        CommentEntity createdComment = commentService.createComment(commentEntity);
        return ResponseEntity.ok(createdComment);
    }

    //댓글 가져오기
    @GetMapping("/{id}")
    public ResponseEntity<CommentEntity> getCommentById(@PathVariable Long id) {
        Optional<CommentEntity> comment = commentService.getCommentById(id);
        return comment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //댓글 수정
    @PutMapping("/{id}")
    public ResponseEntity<CommentEntity> updateComment(@PathVariable Long id, @RequestBody CommentEntity updatedComment) {
        Optional<CommentEntity> comment = commentService.updateComment(id, updatedComment);
        return comment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //댓글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }

    //특정 게시글의 댓글 가져오기
    @GetMapping("/posting/{postingId}")
    public ResponseEntity<List<CommentEntity>> getCommentsByPostingId(@PathVariable String postingId) {
        List<CommentEntity> comments = commentService.getCommentsByPostingId(postingId);
        return ResponseEntity.ok(comments);
    }

    //특정 유저의 댓글 가져오기
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CommentEntity>> getCommentsByUserId(@PathVariable String userId) {
        List<CommentEntity> comments = commentService.getCommentsByUserId(userId);
        return ResponseEntity.ok(comments);
    }
}
