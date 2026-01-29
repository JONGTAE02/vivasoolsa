package org.example.visang_vivasoolsa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 50)
    String name;

    @Column(length = 50)
    String department;

    public Member(String name, String department) {
        this.name = name;
        this.department = department;
    }
}
