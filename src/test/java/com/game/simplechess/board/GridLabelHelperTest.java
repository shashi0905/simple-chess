package com.game.simplechess.board;

import com.game.simplechess.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GridLabelHelperTest {

    @Test
    void testGetGridPositionA1() {
        String testPosition = "A1";     // Position -> row - 0, col - 0
        GridLabelHelper sut = new GridLabelHelper();
        Position result = sut.getGridPosition(testPosition);
        assertEquals(0, result.getRow());
        assertEquals(0, result.getColumn());
    }

    @Test
    void testGetGridPositionH8() {
        String testPosition = "H8";     // Position -> row - 7, col - 7
        GridLabelHelper sut = new GridLabelHelper();
        Position result = sut.getGridPosition(testPosition);
        assertEquals(7, result.getRow());
        assertEquals(7, result.getColumn());
    }

    @Test
    void testGetGridPositionE1() {
        String testPosition = "E1";     // Position -> row - 0, col - 4
        GridLabelHelper sut = new GridLabelHelper();
        Position result = sut.getGridPosition(testPosition);
        assertEquals(0, result.getRow());
        assertEquals(4, result.getColumn());
    }

    @Test
    void testChessNotation00() {
        Position testPosition = new Position(0, 0);
        GridLabelHelper sut = new GridLabelHelper();
        String chessNotation = sut.getChessNotation(testPosition);
        assertEquals("A1", chessNotation);
    }

    @Test
    void testChessNotation77() {
        Position testPosition = new Position(7, 7);
        GridLabelHelper sut = new GridLabelHelper();
        String chessNotation = sut.getChessNotation(testPosition);
        assertEquals("H8", chessNotation);
    }
}
