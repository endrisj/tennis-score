package com.example.tennis.score;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class ScoreCalculationProcessorParameterizedTest {
    private List<String> points;
    private ScoreCalculationProcessor.Player expectedResult;
    private String message;
    private ScoreBoard scoreBoard;
    private ScoreCalculationProcessor processor;
    
    @Before
    public void setup() {
        scoreBoard = mock(ScoreBoard.class);
        processor = new ScoreCalculationProcessor(scoreBoard);
    }

    public ScoreCalculationProcessorParameterizedTest(String message, List<String> points, ScoreCalculationProcessor.Player expectedResult) {
        this.message = message;
        this.points = points;
        this.expectedResult = expectedResult;
    }
    
    @Test
    public void calculateWinner() {
        ScoreCalculationProcessor.Player winner = processor.calculateWinner(points);
        assertEquals(message, expectedResult, winner);
    }
    
    @Parameterized.Parameters
    public static Collection points() {
        return Arrays.asList(new Object[][] {
            // without DEUCE:
            { "1", Arrays.asList("A", "A", "A"),                 ScoreCalculationProcessor.Player.NO_ONE },
            { "2", Arrays.asList("A", "A", "A", "A"),            ScoreCalculationProcessor.Player.A },
            { "3", Arrays.asList("B", "B", "B", "B"),            ScoreCalculationProcessor.Player.B },
            { "4", Arrays.asList("A", "A", "A", "B", "B", "A"),  ScoreCalculationProcessor.Player.A },
            { "5", Arrays.asList("B", "B", "A", "A", "B", "B"),  ScoreCalculationProcessor.Player.B },
            
            // with DEUCE:
            { "6", Arrays.asList("A", "A", "B", "B", "A", "B", "A", "A"),                        ScoreCalculationProcessor.Player.A },
            { "7", Arrays.asList("B", "B", "A", "A", "B", "A", "B", "B"),                        ScoreCalculationProcessor.Player.B },
            { "8", Arrays.asList("A", "A", "B", "B", "A", "B", "A", "B", "A", "B", "A", "B"),    ScoreCalculationProcessor.Player.NO_ONE },
            { "9", Arrays.asList("A", "A", "B", "B", "B", "A", "A", "B", "B", "B"),              ScoreCalculationProcessor.Player.B },
            { "10",Arrays.asList("B", "A", "B", "A", "A", "B", "B", "A", "A", "A"),              ScoreCalculationProcessor.Player.A }            
        });
    }
}
