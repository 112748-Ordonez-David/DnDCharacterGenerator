package org.example.demo1test.services.impl;

import org.example.demo1test.config.MappersConfig;
import org.example.demo1test.entities.CharacterEntity;
import org.example.demo1test.models.Character;
import org.example.demo1test.repositories.CharacterRepository;
import org.example.demo1test.restClient.Dice.DiceDto;
import org.example.demo1test.restClient.Dice.DiceRestClient;
import org.example.demo1test.services.CharacterService;
import org.example.demo1test.services.PdfService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private DiceRestClient diceRestClient;

    @Autowired
    private PdfService pdfService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DiceDto diceTrow(int diceAmount, int diceType) {
        ResponseEntity<DiceDto> responseEntity = diceRestClient.getDice(diceAmount, diceType);

        return responseEntity.getBody(); // Devuelve el cuerpo de la respuesta

    }

    public byte[] testGeneration(){

        return pdfService.generatePdf();
    }

    @Override
    public Character createCharacter(Character character) {
        CharacterEntity characterEntity = modelMapper.map(character, CharacterEntity.class);

        characterRepository.save(characterEntity);
        return modelMapper.map(characterEntity, Character.class);



    }

    @Override
    public Character getCharacterById(int id) {
        Character character = new Character();
        CharacterEntity characterEntity = characterRepository.getReferenceById((long)id);
character = modelMapper.map(characterEntity, Character.class);

        return character;
    }

    @Override
    public List<Character> getAllCharacters() {
        List<CharacterEntity> characterEntities = characterRepository.findAll();
        List<Character> characters = new ArrayList<>();
        for (CharacterEntity characterEntity : characterEntities) {
            characters.add(modelMapper.map(characterEntity, Character.class));

        }
        return characters;
    }


}
