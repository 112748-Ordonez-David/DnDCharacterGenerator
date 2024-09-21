package org.example.demo1test.services;

import org.example.demo1test.restClient.Dice.DiceDto;
import org.springframework.stereotype.Service;

@Service
public interface CharacterService {


    DiceDto diceTrow(int diceAmount, int diceType);

    byte[] testGeneration();
}
