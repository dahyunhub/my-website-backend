package com.backend.service.comment;

import com.backend.domain.comment.Comment;
import com.backend.domain.comment.CommentRepository;
import com.backend.domain.user.User;
import com.backend.domain.user.UserRepository;
import com.backend.dto.comment.CommentCreateRequestDTO;
import com.backend.dto.comment.CommentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    // 방명록 작성
    public void createComment(CommentCreateRequestDTO request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 USER"));

        Comment comment = new Comment(user, request.getContent());

commentRepository.save(comment);
    }

    // 방명록 목록 조회
    public List<CommentResponseDTO> getComments() {
        return commentRepository.findAll().stream()
                .map(comment -> new CommentResponseDTO(
                        comment.getCommentId(),
                        comment.getUser().getRole(),
                        comment.getContent(),
                        comment.getCreatedAt()
                )).collect(Collectors.toList());
    }


}
