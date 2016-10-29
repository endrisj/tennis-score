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
        points = filterInvalidParams(points);
        
        List<Integer> pointsAsNumbers = new ArrayList<>();
        for (String point : points) {
            if ("A".equals(point)) {
                pointsAsNumbers.add(1);
            } else {
                pointsAsNumbers.add(-1);
            }
        }
        pointsAsNumbers.stream().forEach(point -> System.out.print("`"+point+"` "));
        
        
//        return Player.B;
//        /*
        Counter counter = new Counter();
        Sum sum = new Sum();
        IsWinner isWinner = new IsWinner();
        Optional<Integer> winner = pointsAsNumbers.stream()
                .filter(point -> isWinner.isWinner(point))
                .findFirst();
        
        System.out.println("\nREAL WINNER :: "+winner);
        
        /*
        Optional<String> winner = points.stream()
            .filter(point -> scoreCalculator.addPointToPlayer(Player.valueOf(point), scoreBoard))
            .findFirst();
        */
        
//        return Player.valueOf(winner.orElse("NO_ONE"));
        return Player.valueOf("NO_ONE");
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
    
    public static class Counter {
        private int counter = 0;
        public int inc(int numb) {
            System.out.println("COUNTER :: ");
            return ++counter;
        }
    }
    public static class Sum {
        private int sum = 0;
        public int add(int number) {
            sum += number;
            System.out.println("SUM :: "+number+" :: "+sum);
            return sum;
        }
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
