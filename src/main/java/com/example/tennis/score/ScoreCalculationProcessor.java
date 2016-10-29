package com.example.tennis.score;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
//        points = filterInvalidParams(points);
        
//        List<Integer> pointsAsNumbers = new ArrayList<>();
//        for (String point : points) {
//            if ("A".equals(point)) {
//                pointsAsNumbers.add(1);
//            } else {
//                pointsAsNumbers.add(-1);
//            }
//        }
        
        IsWinner isWinner = new IsWinner();
        Optional<String> winner = points.stream()
                .filter(pointFor -> isPlayerNameValid(pointFor))
                .filter(pointFor -> isWinner.isWinner(Player.valueOf(pointFor).nameAsNumber()))
                .findFirst();
        
//        System.out.println("\nREAL WINNER :: "+winner);
        
        /*
        Optional<String> winner = points.stream()
            .filter(point -> scoreCalculator.addPointToPlayer(Player.valueOf(point), scoreBoard))
            .findFirst();
        */
        
        return Player.valueOf(winner.orElse("NO_ONE"));
//        return Player.valueOf("NO_ONE");
    }
    
    public static class IsWinner {
        private int counter = 0;
        private int sum = 0;
        public boolean isWinner(int point) {
            counter++;
            sum += point;
            System.out.println(point+" :: "+counter+" :: "+sum);
            return (
                    (counter > 4 && Math.abs(sum) >= 2)
                    || (counter == 4 && Math.abs(sum) >= 3)
                );
        }
    }
    
    private boolean isPlayerNameValid(String playerName) {
        return Player.A.name().equals(playerName) || Player.B.name().equals(playerName);
    }
    
//    private List<String> filterInvalidParams(List<String> pointSequence) {
//        return pointSequence.stream()
//            
//            .collect(Collectors.toList());
//    }
    
    
    
    
    
    
    public static enum Player {
        A(1),
        B(-1),
        NO_ONE(0);
        
        private int nameAsNumber;
        Player(int nameAsNumber) {
            this.nameAsNumber = nameAsNumber;
        }
        
        public int nameAsNumber() {
            return nameAsNumber;
        }
    }
    
    
    
    private void tmp(String text, List<String> params) {
        System.out.println(text);
        params.stream().forEach(p -> System.out.print(p+", "));
        System.out.println("\n\n");
    }
}
