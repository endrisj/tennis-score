package com.example.tennis.score;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ScoreCalculationProcessor {
    
    private ScoreBoard scoreBoard;

    public ScoreCalculationProcessor(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }
    
    /**
     * 
     * @param scores
     * @return winner
     */
    public Player calculate(List<String> scores) {
        scores = Optional.ofNullable(scores).orElse(new ArrayList<>());
        scores = filterInvalidParams(scores);
        
        return Player.NO_ONE;
    }
    
    private List<String> filterInvalidParams(List<String> scoringSequence) {
        return scoringSequence.stream()
            .filter(point -> Player.A.name().equals(point) || Player.B.name().equals(point))
            .collect(Collectors.toList());
    }
    
    
    
    
    
    
    public static enum Player {
        A,
        B,
        NO_ONE
    }
    
    
    
    private void tmp(String text, List<String> params) {
        System.out.println(text);
        params.stream().forEach(p -> System.out.print(p+", "));
        System.out.println("\n\n");
    }
}
