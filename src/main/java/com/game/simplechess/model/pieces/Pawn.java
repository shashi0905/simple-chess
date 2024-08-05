package com.game.simplechess.model.pieces;

import com.game.simplechess.model.Piece;
import com.game.simplechess.model.PieceColor;
import com.game.simplechess.model.PieceName;
import com.game.simplechess.model.Position;

/**
 * Chess piece of type Pawn.
 * It can only move 1 step at a time, in the vertical forward direction.
 */
public class Pawn extends Piece {

    private PieceColor color;
    private PieceName pieceName;


    public Pawn(PieceName pieceName, PieceColor pieceColor, Position position) {
        super(pieceName, pieceColor, position);
    }

    public Pawn(Position position){
        super(position);
    }

    @Override
    public Position[] getAllPossibleMoves(Piece piece, Position curPosition) {
        Position[] allMoves = new Position[1];  //assuming pawn can only move by 1 step in forward direction
        int newRow = curPosition.getRow() + 1 <= 7 ? curPosition.getRow() + 1 : curPosition.getRow();
        Position position = new Position(newRow, curPosition.getColumn());
        allMoves[0] = position;
        return allMoves;
    }
}
