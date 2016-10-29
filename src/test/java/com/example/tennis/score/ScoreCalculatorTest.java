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
    private Player expectedResult;
    private String message;
    private ScoreCalculator calculator;
    
    @Before
    public void setup() {
        calculator = new ScoreCalculator();
    }

    public ScoreCalculatorTest(String message, List<String> points, Player expectedResult) {
        this.message = message;
        this.points = points;
        this.expectedResult = expectedResult;
    }
    
    @Test
    public void calculateWinner() {
        Player winner = calculator.calculateWinner(points);
        assertEquals(message, expectedResult, winner);
    }
    
    @Parameterized.Parameters
    public static Collection points() {
        return Arrays.asList(new Object[][] {
            // games without DEUCE:
            { "1", null,                                        Player.NO_ONE },
            { "1", Arrays.asList(),                             Player.NO_ONE },
            { "1", Arrays.asList("C"),                          Player.NO_ONE },
            { "1", Arrays.asList("A"),                          Player.NO_ONE },
            { "1", Arrays.asList("B"),                          Player.NO_ONE },
            { "1", Arrays.asList("A", "A", "aa", "A"),          Player.NO_ONE },
            { "1", Arrays.asList("A", "A", "A"),                Player.NO_ONE },
            { "2", Arrays.asList("A", "A", "A", "A"),           Player.A },
            { "3", Arrays.asList("B", "B", "B", "B"),           Player.B },
            { "4", Arrays.asList("A", "A", "A", "B", "A"),      Player.A },
            { "4", Arrays.asList("A", "A", "A", "B", "B", "A"), Player.A },
            { "5", Arrays.asList("B", "B", "A", "A", "B", "B"), Player.B },
            
            // games with DEUCE:
            { "6", Arrays.asList("A", "A", "B", "B", "A", "B", "A", "A"),                        Player.A },
            { "7", Arrays.asList("B", "B", "A", "A", "B", "A", "B", "B"),                        Player.B },
            { "8", Arrays.asList("A", "A", "B", "B", "A", "B", "A", "B", "A", "B", "A", "B"),    Player.NO_ONE },
            { "9", Arrays.asList("A", "A", "B", "B", "B", "A", "A", "B", "B", "B"),              Player.B },
            { "10",Arrays.asList("B", "A", "B", "A", "A", "B", "B", "A", "A", "A"),              Player.A }            
        });
    }
}
