package org.example.visang_vivasoolsa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String content;

    @CreationTimestamp
    private LocalDateTime createdAt;

    // who
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // 어떤 믿음에 대해 (목록 조회용)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "belief_id")
    private Belief belief;
}
