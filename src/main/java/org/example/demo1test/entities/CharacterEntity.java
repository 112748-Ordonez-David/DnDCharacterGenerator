package org.example.demo1test.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Setter
@NoArgsConstructor
@Table(name = "characters")
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "strength", nullable = false)

    private int strength;

    @Column(name = "intelligence", nullable = false)

    private int intelligence;

    @Column(name = "constitution", nullable = false)

    private int constitution;

    @Column(name = "dexterity", nullable = false)

    private int dexterity;

    @Column(name = "charisma", nullable = false)

    private int charisma;

    @Column(name = "wisdom", nullable = false)

    private int wisdom;

}
