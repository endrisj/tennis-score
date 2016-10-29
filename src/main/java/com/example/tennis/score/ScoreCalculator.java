package com.example.tennis.score;

import java.util.HashMap;
import java.util.Map;

public class ScoreCalculator {

    private Map<ScoreCalculationProcessor.Player, Integer> playerPoints = new HashMap<>();

    public ScoreCalculator() {
        // TODO: maybe move Player to separate class
        // TODO: maybe remove this class and go back to ScoreCalculationProcessor
        // TODO: mayeb rename back ScoreCalculationProcessor to ScoreCalculation
        
        playerPoints.put(ScoreCalculationProcessor.Player.A, 0);
        playerPoints.put(ScoreCalculationProcessor.Player.B, 0);
    }
    
    public void addPointToPlayer(ScoreCalculationProcessor.Player player, ScoreBoard scoreBoard) {
        playerPoints.put(player, playerPoints.get(player)+1);
        
        int playerAPoints = playerPoints.get(ScoreCalculationProcessor.Player.A);
        int playerBPoints = playerPoints.get(ScoreCalculationProcessor.Player.B);
        
        String result = PointCall.values()[playerAPoints]+" :: "+PointCall.values()[playerBPoints];
        scoreBoard.publish(result);
    }
}
