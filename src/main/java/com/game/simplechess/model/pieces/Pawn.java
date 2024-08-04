package com.game.simplechess.model.pieces;

import com.game.simplechess.model.Piece;
import com.game.simplechess.model.PieceColor;

/**
 * Chess piece of type Pawn.
 * It can only move 1 step at a time, in the vertical forward direction.
 */
public class Pawn extends Piece {


    public Pawn(PieceColor pieceColor, int x, int y) {
        super(pieceColor, x, y);
    }

    @Override
    public Boolean getAllPossibleMoves(Piece piece, int x, int y) {
        return null;
    }
}
