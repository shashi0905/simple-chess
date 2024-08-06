package com.game.simplechess.model.pieces;

import com.game.simplechess.model.Piece;
import com.game.simplechess.model.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Chess piece of type King.
 * It can only move 1 step at a time, in all 8 directions (vertical, horizontal and diagonal)
 * <br>
 * Created by Shashi Mourya on 06/08/2024
 */
public class King extends Piece {

    public King(Position position) {
        super(position);
    }

    @Override
    public List<Position> getAllPossibleMoves(Piece piece, Position curPosition) {
        List<Position> moves = new ArrayList<>();

        // Directions the king can move: one step in any direction
        int[][] directions = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}, // Vertical and horizontal
                {-1, -1}, {1, 1}, {-1, 1}, {1, -1} // Diagonal
        };

        for (int[] direction : directions) {
            int newRow = curPosition.getRow() + direction[0];
            int newCol = curPosition.getColumn() + direction[1];

            // Check if the new position is within the bounds of the chess board
            if (isInBounds(newRow, newCol)) {
                moves.add(new Position(newRow, newCol));
            }
        }

        return moves;
    }
}
