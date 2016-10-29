package com.example.tennis.score;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ScoreCalculatorTest {
    private List<String> points;
    private ScoreCalculator.Player expectedResult;
    private String message;
    private ScoreCalculator calculator;
    
    @Before
    public void setup() {
        calculator = new ScoreCalculator();
    }

    public ScoreCalculatorTest(String message, List<String> points, ScoreCalculator.Player expectedResult) {
        this.message = message;
        this.points = points;
        this.expectedResult = expectedResult;
    }
    
    @Test
    public void calculateWinner() {
        ScoreCalculator.Player winner = calculator.calculateWinner(points);
        assertEquals(message, expectedResult, winner);
    }
    
    @Parameterized.Parameters
    public static Collection points() {
        return Arrays.asList(new Object[][] {
            // games without DEUCE:
            { "1", null,                                        ScoreCalculator.Player.NO_ONE },
            { "1", Arrays.asList(),                             ScoreCalculator.Player.NO_ONE },
            { "1", Arrays.asList("C"),                          ScoreCalculator.Player.NO_ONE },
            { "1", Arrays.asList("A"),                          ScoreCalculator.Player.NO_ONE },
            { "1", Arrays.asList("B"),                          ScoreCalculator.Player.NO_ONE },
            { "1", Arrays.asList("A", "A", "aa", "A"),          ScoreCalculator.Player.NO_ONE },
            { "1", Arrays.asList("A", "A", "A"),                ScoreCalculator.Player.NO_ONE },
            { "2", Arrays.asList("A", "A", "A", "A"),           ScoreCalculator.Player.A },
            { "3", Arrays.asList("B", "B", "B", "B"),           ScoreCalculator.Player.B },
            { "4", Arrays.asList("A", "A", "A", "B", "B", "A"), ScoreCalculator.Player.A },
            { "5", Arrays.asList("B", "B", "A", "A", "B", "B"), ScoreCalculator.Player.B },
            
            // games with DEUCE:
            { "6", Arrays.asList("A", "A", "B", "B", "A", "B", "A", "A"),                        ScoreCalculator.Player.A },
            { "7", Arrays.asList("B", "B", "A", "A", "B", "A", "B", "B"),                        ScoreCalculator.Player.B },
            { "8", Arrays.asList("A", "A", "B", "B", "A", "B", "A", "B", "A", "B", "A", "B"),    ScoreCalculator.Player.NO_ONE },
            { "9", Arrays.asList("A", "A", "B", "B", "B", "A", "A", "B", "B", "B"),              ScoreCalculator.Player.B },
            { "10",Arrays.asList("B", "A", "B", "A", "A", "B", "B", "A", "A", "A"),              ScoreCalculator.Player.A }            
        });
    }
}
