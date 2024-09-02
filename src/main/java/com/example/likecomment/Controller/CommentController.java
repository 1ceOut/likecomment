package com.example.likecomment.Controller;

import com.example.likecomment.Entity.CommentEntity;
import com.example.likecomment.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
//@CrossOrigin(origins = {"http://localhost:8080"}, allowCredentials = "true")
public class CommentController {

    @Autowired
    private CommentService commentService;

    //댓글 만들기
    @PostMapping("/insert")
    public ResponseEntity<CommentEntity> createComment(@RequestBody CommentEntity commentEntity) {
        CommentEntity createdComment = commentService.createComment(commentEntity);
        return ResponseEntity.ok(createdComment);
    }

    //댓글 가져오기
    @GetMapping("/list/{id}")
    public ResponseEntity<CommentEntity> getCommentById(@PathVariable Long id) {
        Optional<CommentEntity> comment = commentService.getCommentById(id);
        return comment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //댓글 수정
    @PutMapping("/update")
    public ResponseEntity<CommentEntity> updateComment(@RequestParam Long id, @RequestBody CommentEntity updatedComment) {
        Optional<CommentEntity> comment = commentService.updateComment(id, updatedComment);
        return comment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //댓글 삭제
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteComment(@RequestParam Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }

    //특정 유저의 댓글 가져오기
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CommentEntity>> getCommentsByUserId(@PathVariable String userId) {
        List<CommentEntity> comments = commentService.getCommentsByUserId(userId);
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/listByUser")
    public ResponseEntity<Map<String, Object>> getUserByUserDetails(@RequestParam String postingId) {
        List<Map<String, Object>> commentsWithUserDetails = commentService.getCoomentsByPostingId(postingId);
        if (commentsWithUserDetails == null) {
            commentsWithUserDetails = Collections.emptyList();  // 또는 적절한 빈 리스트 생성
        }
        return ResponseEntity.ok(Map.of("comments", commentsWithUserDetails));
    }
}
