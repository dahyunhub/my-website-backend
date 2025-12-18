package com.backend.dto.comment;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentCreateRequestDTO {
    private Long userId;
    private String content;
}
