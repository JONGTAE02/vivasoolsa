package org.example.visang_vivasoolsa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Fortune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;     // 운세 문장
    private String question;    // 행동 질문
    private String luckyItem;   // 행운 아이템
    private String characterImageUrl; // 캐릭터 이미지

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "belief_id")
    private Belief belief;

}
