package com.example.tennis.score;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScoreCalculator {
    
    private int totalPointsInThisServe = 0;
    private int pointsDiffBetweenPlayers = 0;
    
    /**
     * @param points
     * @return winner
     */
    public Player calculateWinner(List<String> points) {
        points = Optional.ofNullable(points).orElse(new ArrayList<>());
        Optional<String> winner = points.stream()
                .filter(pointFor -> isPlayerNameValid(pointFor))
                .filter(pointFor -> doWeHaveWinner(Player.valueOf(pointFor).nameAsNumber()))
                .findFirst();
        return Player.valueOf(winner.orElse("NO_ONE"));
    }
    
    private boolean isPlayerNameValid(String playerName) {
        return Player.A.name().equals(playerName) || Player.B.name().equals(playerName);
    }
    
    public boolean doWeHaveWinner(int point) {
        totalPointsInThisServe++;
        pointsDiffBetweenPlayers += point;
        return (
                (totalPointsInThisServe > 4 && Math.abs(pointsDiffBetweenPlayers) >= 2)
                || (totalPointsInThisServe == 4 && Math.abs(pointsDiffBetweenPlayers) >= 3)
            );
    }
}
