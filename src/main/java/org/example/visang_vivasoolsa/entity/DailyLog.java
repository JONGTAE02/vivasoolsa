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
public class DailyLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp // 저장될 때 시간 자동 입력
    private LocalDateTime createdAt;

    private Boolean isGolden; // 황금 접속 여부
    private String rewardResult; // 당첨 결과

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // 무엇을 -> 운세를 알면 믿음도 알 수 있음
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fortune_id")
    private Fortune fortune;
}
