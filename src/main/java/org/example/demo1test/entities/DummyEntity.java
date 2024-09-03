package org.example.demo1test.entities;

import jakarta.persistence.*;

@Entity
public class DummyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id", nullable = false)
    private Long id;

    private String dummy;
}
