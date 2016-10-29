package com.example.tennis;

import com.example.tennis.score.ScoreCalculationProcessor;
import java.util.Arrays;

public class ScoreApplication {
    
    public static void main(String[] args) {
        ScoreCalculationProcessor.Player winner = (new ScoreCalculationProcessor()).calculateWinner(Arrays.asList(args));
        System.out.println("And the winner is `"+winner+"`!");
    }
}
