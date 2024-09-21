package org.example.demo1test.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Character {

    private Long id;

    private String name;

    private int strength;

    private int intelligence;

    private int constitution;

    private int dexterity;

    private int charisma;

    private int wisdom;



}
