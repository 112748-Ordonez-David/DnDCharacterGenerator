package org.example.demo1test.services;

import org.example.demo1test.models.Character;
import org.example.demo1test.restClient.Dice.DiceDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CharacterService {


    DiceDto diceTrow(int diceAmount, int diceType);

    byte[] testGeneration();

    Character createCharacter(Character character);

    Character getCharacterById(int id);

    List<Character> getAllCharacters();
}
