package com.game.simplechess.model.pieces;

import com.game.simplechess.model.Piece;
import com.game.simplechess.model.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Chess piece of type Pawn.
 * It can move across the board in all 8 directions.
 * <br>
 * Created by Shashi Mourya on 06/08/2024
 */
public class Queen extends Piece {

    public Queen(Position position) {
        super(position);
    }

    @Override
    public List<Position> getAllPossibleMoves(Piece piece, Position curPosition) {

        List<Position> moves = new ArrayList<>();

        // Directions the queen can move: vertically, horizontally, and diagonally
        int[][] directions = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}, // Vertical and horizontal
                {-1, -1}, {1, 1}, {-1, 1}, {1, -1} // Diagonal
        };

        for (int[] direction : directions) {
            int newRow = curPosition.getRow() + direction[0];
            int newCol = curPosition.getColumn() + direction[1];
            while (isInBounds(newRow, newCol)) {
                moves.add(new Position(newRow, newCol));
                newRow += direction[0];
                newCol += direction[1];
            }
        }
        return moves;
    }
}
