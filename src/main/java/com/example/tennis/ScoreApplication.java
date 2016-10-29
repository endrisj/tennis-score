package com.example.tennis;

import com.example.tennis.score.ScoreBoard;
import com.example.tennis.score.ScoreCalculationProcessor;
import java.util.Arrays;

public class ScoreApplication {
    
    public static void main(String[] args) {
        ScoreCalculationProcessor.Player winner = (new ScoreCalculationProcessor(new PrintToConsoleScoreBoard())).calculate(Arrays.asList(args));
        System.out.println("And the winner is `"+winner+"`!");
    }
    
    public static class PrintToConsoleScoreBoard implements ScoreBoard {
        @Override
        public void publish(String result) {
            System.out.println(result);
        }
    }
}
