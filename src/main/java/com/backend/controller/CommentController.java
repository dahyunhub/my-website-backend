package com.backend.controller;


import com.backend.dto.comment.CommentCreateRequestDTO;
import com.backend.dto.comment.CommentResponseDTO;
import com.backend.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;


    // 방명록 등록
    @PostMapping
    public ResponseEntity<CommentResponseDTO> createComment(
            @RequestBody CommentCreateRequestDTO requestDTO) {

        CommentResponseDTO response = commentService.createComment(requestDTO);

        return ResponseEntity.ok(response);
    }

    // 방명록 전체 조회
    @GetMapping
    public ResponseEntity<List<CommentResponseDTO>> getComments() {
        List<CommentResponseDTO> comments = commentService.getComments();

        return ResponseEntity.ok(comments);
    }
}
