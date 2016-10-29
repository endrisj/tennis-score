package com.example.tennis.score;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScoreCalculator {
    
    /**
     * 
     * @param points
     * @return winner
     */
    public Player calculateWinner(List<String> points) {
        points = Optional.ofNullable(points).orElse(new ArrayList<>());
        IsWinner isWinner = new IsWinner();
        Optional<String> winner = points.stream()
                .filter(pointFor -> isPlayerNameValid(pointFor))
                .filter(pointFor -> isWinner.isWinner(Player.valueOf(pointFor).nameAsNumber()))
                .findFirst();
        
        return Player.valueOf(winner.orElse("NO_ONE"));
    }
    
    private boolean isPlayerNameValid(String playerName) {
        return Player.A.name().equals(playerName) || Player.B.name().equals(playerName);
    }
    
    
    
    public static class IsWinner {
        private int counter = 0;
        private int sum = 0;
        public boolean isWinner(int point) {
            counter++;
            sum += point;
            return (
                    (counter > 4 && Math.abs(sum) >= 2)
                    || (counter == 4 && Math.abs(sum) >= 3)
                );
        }
    }
}
