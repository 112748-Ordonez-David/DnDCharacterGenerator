package org.example.demo1test.restClient.Dice;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Data
@Service
public class DiceRestClient {

    String baseResourceUrl = "https://rpg-dice-roller-api.djpeacher.com/api/roll";

    @Autowired
    private RestTemplate restTemplate;

public ResponseEntity<DiceDto> getDice(int amount, int type)
{
    return restTemplate.getForEntity(baseResourceUrl+"/"+amount+"d"+
                    type,
            DiceDto.class);
}



}
