package org.example.demo1test.services.impl;

import org.example.demo1test.repositories.CharacterRepository;
import org.example.demo1test.restClient.Dice.DiceDto;
import org.example.demo1test.restClient.Dice.DiceRestClient;
import org.example.demo1test.services.CharacterService;
import org.example.demo1test.services.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private DiceRestClient diceRestClient;

    @Autowired
    private PdfService pdfService;


    @Override
    public DiceDto diceTrow(int diceAmount, int diceType) {
        ResponseEntity<DiceDto> responseEntity = diceRestClient.getDice(diceAmount, diceType);

        return responseEntity.getBody(); // Devuelve el cuerpo de la respuesta

    }

    public byte[] testGeneration(){

        return pdfService.generatePdf();
    }



}
