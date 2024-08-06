package com.game.simplechess.model.pieces;

import com.game.simplechess.model.Piece;
import com.game.simplechess.model.PieceName;
import com.game.simplechess.model.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Chess piece of type Pawn.
 * It can only move 1 step at a time, in the vertical forward direction.
 *
 * Created by Shashi Mourya on 06/08/2024
 */
public class Pawn extends Piece {

    public Pawn(Position position){
        super(position);
        this.setPieceName(PieceName.PAWN);
    }

    @Override
    public List<Position> getAllPossibleMoves(Piece piece, Position curPosition) {
        List<Position> allMoves = new ArrayList<>();
        int newRow = curPosition.getRow() + 1 <= 7 ? curPosition.getRow() + 1 : curPosition.getRow();
        Position position = new Position(newRow, curPosition.getColumn());
        allMoves.add(position);
        return allMoves;
    }
}
