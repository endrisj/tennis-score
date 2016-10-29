package com.example.tennis.score;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;

public class ScoreCalculationProcessorTest {
    
    private ScoreBoard scoreBoard;
    private ScoreCalculationProcessor processor;
    
    @Before
    public void setup() {
        scoreBoard = mock(ScoreBoard.class);
        processor = new ScoreCalculationProcessor(scoreBoard);
    }
    
    /**
     * TODO:
     * use some kind of repeating procedure for testing, because all the test will be very similar
     */
    
    @Test
    public void calculate_withNullParams_noScorePrintedAndNoWinner() {
        ScoreCalculationProcessor.Player winner = processor.calculate(null);
        verify(scoreBoard, never()).publish(any(String.class));
        assertEquals(ScoreCalculationProcessor.Player.NO_ONE, winner);
    }
    
    @Test
    public void calculate_withEmptyParams_noScorePrintedAndNoWinner() {
        List<String> points = Arrays.asList();
        ScoreCalculationProcessor.Player winner = processor.calculate(points);
        verify(scoreBoard, never()).publish(any(String.class));
        assertEquals(ScoreCalculationProcessor.Player.NO_ONE, winner);
    }
    
    @Test
    public void calculate_withWrongParam_paramIsIgnored() {
        List<String> points = Arrays.asList("C");
        ScoreCalculationProcessor.Player winner = processor.calculate(points);
        verify(scoreBoard, never()).publish(any(String.class));
        assertEquals(ScoreCalculationProcessor.Player.NO_ONE, winner);
    }
    
    @Test
    public void calculate_withOneAPoint_scorePrintedAndNoWinner() {
        List<String> points = Arrays.asList("A");
        ScoreCalculationProcessor.Player winner = processor.calculate(points);
        verify(scoreBoard, times(1)).publish("Fifteen :: Love");
        assertEquals(ScoreCalculationProcessor.Player.NO_ONE, winner);
    }
    
    @Test
    public void calculate_withOneBPoint_scorePrintedAndNoWinner() {
        List<String> points = Arrays.asList("B");
        ScoreCalculationProcessor.Player winner = processor.calculate(points);
        verify(scoreBoard, times(1)).publish("Love :: Fifteen");
        assertEquals(ScoreCalculationProcessor.Player.NO_ONE, winner);
    }
}
