package com.backend.domain.post;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @Column(length = 200, nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(name = "post_type", length = 50, nullable = false)
    private String postType;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public Post(String title, String content, String postType) {
        this.title = title;
        this.content = content;
        this.postType = postType;
        this.createdAt = LocalDateTime.now();
    }
}
