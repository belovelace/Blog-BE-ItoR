package com.blog.comment.controller;

import com.blog.comment.record.CommentRecord;
import com.blog.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService service;

    // 댓글 목록 조회
    @GetMapping("/showComment")
    public ResponseEntity<List<CommentRecord>> showComments(
            @RequestParam Integer postId
    ) {
        return ResponseEntity.ok(service.getComments(postId));
    }

    //댓글 작성 (삽입) : 로그인 시에만 가능하다.
    @PostMapping("/write")
    public ResponseEntity<Integer> writeComment(
            @RequestBody CommentRecord rec,
            @RequestHeader("X-USER-ID") String userId
    ) {
        CommentRecord toInsert = new CommentRecord(
                null,
                userId,
                rec.postId(),
                rec.content(),
                null,
                null,
                false
        );
        return ResponseEntity.ok(service.createComment(toInsert));
    }

    // 댓글 수정 : 작성자만
    @PutMapping("/edit")
    public ResponseEntity<?> editComment(
            @RequestBody CommentRecord record,
            @RequestHeader("X-USER-ID") String userId
    ) {
        CommentRecord toUpdate = new CommentRecord(
                record.commentNum(),
                userId,
                record.postId(),
                record.content(),
                record.createdAt(),
                record.updateAt(),
                record.isDeleted()
        );
        service.updateComment(toUpdate);
        return ResponseEntity.ok("댓글 수정 완료");
    }

    @DeleteMapping("/{commentNum}")
    public ResponseEntity<?> deleteComment(
            @PathVariable Integer commentNum,
            @RequestHeader("X-USER-ID") String userId
    ) {
        CommentRecord toDelete = new CommentRecord(
                commentNum,
                userId,
                null,
                null,
                null,
                null,
                false
        );
        service.deleteComment(toDelete);
        return ResponseEntity.ok("댓글 삭제 완료");
    }

















}//class
