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
    public void calculateWinner_withNullParams_noScorePrintedAndNoWinner() {
        ScoreCalculationProcessor.Player winner = processor.calculateWinner(null);
        verify(scoreBoard, never()).publish(any(String.class));
        assertEquals(ScoreCalculationProcessor.Player.NO_ONE, winner);
    }
    
    @Test
    public void calculateWinner_withEmptyParams_noScorePrintedAndNoWinner() {
        List<String> points = Arrays.asList();
        ScoreCalculationProcessor.Player winner = processor.calculateWinner(points);
        verify(scoreBoard, never()).publish(any(String.class));
        assertEquals(ScoreCalculationProcessor.Player.NO_ONE, winner);
    }
    
    @Test
    public void calculateWinner_withWrongParam_paramIsIgnored() {
        List<String> points = Arrays.asList("C");
        ScoreCalculationProcessor.Player winner = processor.calculateWinner(points);
        verify(scoreBoard, never()).publish(any(String.class));
        assertEquals(ScoreCalculationProcessor.Player.NO_ONE, winner);
    }
    
    @Test
    public void calculateWinner_withOneAPoint_scorePrintedAndNoWinner() {
        List<String> points = Arrays.asList("A");
        ScoreCalculationProcessor.Player winner = processor.calculateWinner(points);
        verify(scoreBoard, times(1)).publish("FIFTEEN :: LOVE");
        assertEquals(ScoreCalculationProcessor.Player.NO_ONE, winner);
    }
    
    @Test
    public void calculateWinner_withOneBPoint_scorePrintedAndNoWinner() {
        List<String> points = Arrays.asList("B");
        ScoreCalculationProcessor.Player winner = processor.calculateWinner(points);
        verify(scoreBoard, times(1)).publish("LOVE :: FIFTEEN");
        assertEquals(ScoreCalculationProcessor.Player.NO_ONE, winner);
    }
}
