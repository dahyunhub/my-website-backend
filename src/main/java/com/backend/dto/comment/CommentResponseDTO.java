package com.backend.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentResponseDTO {
    private Long commentId;
    private String role;
    private String content;
    private LocalDateTime createdAt;
}
