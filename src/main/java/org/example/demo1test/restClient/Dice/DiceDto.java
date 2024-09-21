package org.example.demo1test.restClient.Dice;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
public class DiceDto {

    private int averageTotal;
    private int maxTotal;
    private int minTotal;
    private String output;
    private int total;
}
