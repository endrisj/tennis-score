package com.example.tennis.score;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ScoreCalculationProcessor {
    
    private ScoreBoard scoreBoard;
    private ScoreCalculator scoreCalculator;

    public ScoreCalculationProcessor(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
        scoreCalculator = new ScoreCalculator();
    }
    
    /**
     * 
     * @param points
     * @return winner
     */
    public Player calculateWinner(List<String> points) {
        
        points = Optional.ofNullable(points).orElse(new ArrayList<>());
        points = filterInvalidParams(points);
        
        points.stream()
            .forEach(point -> scoreCalculator.addPointToPlayer(Player.valueOf(point), scoreBoard));
        
        return Player.NO_ONE;
    }
    
    private List<String> filterInvalidParams(List<String> pointSequence) {
        return pointSequence.stream()
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
