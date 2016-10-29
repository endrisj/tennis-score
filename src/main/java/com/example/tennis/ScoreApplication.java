package com.example.tennis;

import com.example.tennis.score.ScoreCalculator;
import java.util.Arrays;

public class ScoreApplication {
    
    public static void main(String[] args) {
        ScoreCalculator.Player winner = (new ScoreCalculator()).calculateWinner(Arrays.asList(args));
        System.out.println("And the winner is `"+winner+"`!");
    }
}
