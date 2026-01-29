package org.example.visang_vivasoolsa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Belief {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 1~7번

    @Column(length = 100)
    private String title; // 핵심 가치

    @Column(columnDefinition = "TEXT")
    private String meaning; // 믿음의 의미

    private String imageUrl;

    public Belief(String title, String meaning, String imageUrl) {
        this.title = title;
        this.meaning = meaning;
        this.imageUrl = imageUrl;
    }

}
