package org.example.demo1test.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDto {

    private Long id;

    private String name;

    private int strength;

    private int intelligence;

    private int constitution;

    private int dexterity;

    private int charisma;

    private int wisdom;




}
