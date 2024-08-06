package com.game.simplechess.board;

import com.game.simplechess.model.PieceName;
import com.game.simplechess.model.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

/**
 * Created by Shashi Mourya on 06/08/2024
 */
class ChessBoardTest {

    private ChessBoard sut;
    private final GridLabelHelper gridLabelHelperMock = Mockito.mock(GridLabelHelper.class);

    @Test
    void testSetPiecePositionOnBoard() {
        sut = new ChessBoard(gridLabelHelperMock);
        String position = "A1";
        String piece = "PAWN";

        Position gridPosition = new Position(0,0);
        when(gridLabelHelperMock.getGridPosition(position)).thenReturn(gridPosition);

        sut.setPiecePositionOnBoard(position, piece);
        assertNotNull(sut.getBoard());
        assertNotNull(sut.getPieceOnBoardPosition(gridPosition));
        assertEquals(PieceName.PAWN, sut.getPieceOnBoardPosition(gridPosition).getPieceName());
    }

    @Test
    void testGetAllPossibleMovesPawn() {
        sut = new ChessBoard(gridLabelHelperMock);
        String position = "A1";
        String piece = "PAWN";

        Position gridPosition = new Position(0,0);
        Position expectedPosition = new Position(1, 0);
        when(gridLabelHelperMock.getGridPosition(position)).thenReturn(gridPosition);
        when(gridLabelHelperMock.getChessNotation(refEq(expectedPosition))).thenReturn("A2");

        List<String> result = sut.getAllPossibleMoves(position, piece);
        assertNotNull(result);
        assertEquals("A2", result.get(0));
    }

    @Test
    void testBoundsWithPawn() {
        sut = new ChessBoard(gridLabelHelperMock);
        String position = "F8";
        String piece = "PAWN";

        Position gridPosition = new Position(7,5);
        Position expectedPosition = new Position(7, 5);
        when(gridLabelHelperMock.getGridPosition(position)).thenReturn(gridPosition);
        when(gridLabelHelperMock.getChessNotation(refEq(expectedPosition))).thenReturn("F8");
        List<String> result = sut.getAllPossibleMoves(position, piece);
        assertNotNull(result);
        assertEquals("F8", result.get(0));
    }


    @Test
    void testGetAllPossibleMovesKing() {
        sut = new ChessBoard(gridLabelHelperMock);
        String position = "D5";
        String piece = "KING";

        Position gridPosition = new Position(4,3);
        Position expectedPositionD4 = new Position(3, 3);
        Position expectedPositionE4 = new Position(3, 4);
        Position expectedPositionD6 = new Position(5, 3);
        when(gridLabelHelperMock.getGridPosition(position)).thenReturn(gridPosition);
        when(gridLabelHelperMock.getChessNotation(refEq(expectedPositionD4))).thenReturn("D4");
        when(gridLabelHelperMock.getChessNotation(refEq(expectedPositionE4))).thenReturn("E4");
        when(gridLabelHelperMock.getChessNotation(refEq(expectedPositionD6))).thenReturn("D6");

        List<String> result = sut.getAllPossibleMoves(position, piece);
        assertNotNull(result);
        assertTrue(result.contains("D4"));  // verify vertical backward movement
        assertTrue(result.contains("E4"));  // verify diagonal movement
        assertTrue(result.contains("D6"));  // verify vertical forward movement
    }

    @Test
    void testGetAllPossibleMovesQueen() {
        sut = new ChessBoard(gridLabelHelperMock);
        String position = "E4";
        String piece = "QUEEN";

        Position gridPosition = new Position(3,4);
        Position expectedPositionD4 = new Position(3, 3);
        Position expectedPositionA8 = new Position(7, 0);
        Position expectedPositionE1 = new Position(0, 4);
        when(gridLabelHelperMock.getGridPosition(position)).thenReturn(gridPosition);
        when(gridLabelHelperMock.getChessNotation(refEq(expectedPositionD4))).thenReturn("D4");
        when(gridLabelHelperMock.getChessNotation(refEq(expectedPositionA8))).thenReturn("A8");
        when(gridLabelHelperMock.getChessNotation(refEq(expectedPositionE1))).thenReturn("E1");

        List<String> result = sut.getAllPossibleMoves(position, piece);
        assertNotNull(result);
        assertTrue(result.contains("D4"));
        assertTrue(result.contains("A8"));
        assertTrue(result.contains("E1"));
    }
}
