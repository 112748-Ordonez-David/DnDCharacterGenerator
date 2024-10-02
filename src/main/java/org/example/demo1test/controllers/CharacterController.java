package org.example.demo1test.controllers;

import org.example.demo1test.dtos.DummyDto;
import org.example.demo1test.models.Character;
import org.example.demo1test.models.Dummy;
import org.example.demo1test.restClient.Dice.DiceDto;
import org.example.demo1test.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private CharacterService characterService;


    @GetMapping("/dice/{amount}/{type}")
    public ResponseEntity<DiceDto> trowDice(@PathVariable int amount,
                                                 @PathVariable int type) {
        DiceDto diceTrow = characterService.diceTrow(amount, type);

        return ResponseEntity.ok(diceTrow);
    }


    @GetMapping("/testGeneration")
    public ResponseEntity<byte[]> generatePdf(){

        byte[] testDate = characterService.testGeneration();

        return ResponseEntity.ok(testDate);


    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Character>> getAll(){

        List<Character> characters = characterService.getAllCharacters();

        return ResponseEntity.ok(characters);

    }

    @PostMapping
    public ResponseEntity<Character> createCharacter(@RequestBody Character character) {

        Character newCharacter = characterService.createCharacter(character);
        return ResponseEntity.ok(newCharacter);
    }




}

