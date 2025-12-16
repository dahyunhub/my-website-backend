package com.backend.domain.visitor;

import com.backend.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "VISITORS")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visitor_id")
    private Long visitorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "ip_address", length = 45)
    private String ipAddress;

    @Column(name = "user_agent", length = 250)
    private String userAgent;

    @Column(name = "visited_at", nullable = false)
    private LocalDate visitedAt;

    public Visitor (User user, String ipAddress, String userAgent) {
        this.user = user;
        this.ipAddress =ipAddress;
        this.userAgent = userAgent;
        this.visitedAt = LocalDate.now();
    }
}
