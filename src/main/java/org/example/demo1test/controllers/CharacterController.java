package org.example.demo1test.controllers;

import org.example.demo1test.dtos.DummyDto;
import org.example.demo1test.models.Dummy;
import org.example.demo1test.restClient.Dice.DiceDto;
import org.example.demo1test.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
