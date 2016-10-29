package com.example.tennis.score;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;

public class ScoreCalculatorTest {
    
    private ScoreBoard scoreBoard;
    private ScoreCalculator calculator;
    
    @Before
    public void setup() {
        scoreBoard = mock(ScoreBoard.class);
        calculator = new ScoreCalculator(scoreBoard);
    }
    
    /**
     * TODO:
     * use some kind of repeating procedure for testing, because all the test will be very similar
     */
    
    @Test
    public void calculate_withNullParams_noScorePrintedAndNoWinner() {
        ScoreCalculator.Player winner = calculator.calculate(null);
        verify(scoreBoard, never()).publish(any(String.class));
        assertEquals(ScoreCalculator.Player.NO_ONE, winner);
    }
    
    @Test
    public void calculate_withEmptyParams_noScorePrintedAndNoWinner() {
        List<String> points = Arrays.asList();
        ScoreCalculator.Player winner = calculator.calculate(points);
        verify(scoreBoard, never()).publish(any(String.class));
        assertEquals(ScoreCalculator.Player.NO_ONE, winner);
    }
    
    @Test
    public void calculate_withWrongParam_paramIsIgnored() {
        List<String> points = Arrays.asList("C");
        ScoreCalculator.Player winner = calculator.calculate(points);
        verify(scoreBoard, never()).publish(any(String.class));
        assertEquals(ScoreCalculator.Player.NO_ONE, winner);
    }
    
    @Test
    public void calculate_withOneAPoint_scorePrintedAndNoWinner() {
        List<String> points = Arrays.asList("A");
        ScoreCalculator.Player winner = calculator.calculate(points);
        verify(scoreBoard, times(1)).publish("Fifteen :: Love");
        assertEquals(ScoreCalculator.Player.NO_ONE, winner);
    }
    
    @Test
    public void calculate_withOneBPoint_scorePrintedAndNoWinner() {
        List<String> points = Arrays.asList("B");
        ScoreCalculator.Player winner = calculator.calculate(points);
        verify(scoreBoard, times(1)).publish("Love :: Fifteen");
        assertEquals(ScoreCalculator.Player.NO_ONE, winner);
    }
}
