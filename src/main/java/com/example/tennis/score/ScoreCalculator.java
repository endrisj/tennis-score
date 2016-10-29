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
    
    public boolean addPointToPlayer(ScoreCalculationProcessor.Player player) {
        playerPoints.put(player, playerPoints.get(player)+1);
        
        int playerAPoints = playerPoints.get(ScoreCalculationProcessor.Player.A);
        int playerBPoints = playerPoints.get(ScoreCalculationProcessor.Player.B);
        
        String result = PointCall.values()[playerAPoints]+" :: "+PointCall.values()[playerBPoints];
//        scoreBoard.publish(result);
        
        return playerPoints.get(player) >= 4;
    }
    
    private boolean isGame(int firstPlayerPoints, int opponentPlayerPoints) {
        return (firstPlayerPoints > 3 && (firstPlayerPoints - opponentPlayerPoints) >= 2);
    }
    
    private boolean isDeuce(int firstPlayerPoints, int opponentPlayerPoints) {
        return ((firstPlayerPoints + opponentPlayerPoints) > 5 && firstPlayerPoints == opponentPlayerPoints);
    }
    
    private boolean isAdvantage(int firstPlayerPoints, int opponentPlayerPoints) {
        return ((firstPlayerPoints + opponentPlayerPoints) > 6 && (firstPlayerPoints - opponentPlayerPoints) == 1);
    }
}
