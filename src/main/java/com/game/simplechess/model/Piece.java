package com.game.simplechess.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.game.simplechess.board.ChessBoardConstants.BOARD_SIZE;

@Setter
@Getter
@AllArgsConstructor
public abstract class Piece {

    private PieceName pieceName;
    private PieceColor pieceColor;
    private Position position;

    /**
     * Instantiates a piece with given position in the grid,
     * without needing the extra attributes color and name.
     *
     * @param position row and column position of the piece in the chess grid
     */
    protected Piece(Position position){
        this.position = position;
    }

    /**
     * Finds all the possible moves for a given chess piece, from a given position in the grid
     *
     * @param piece         the piece instance of given type
     * @param curPosition   the current position of the piece on the chess grid
     * @return  All the possible positions in the grid, where the chess piece can move from the current position
     */
    public abstract List<Position> getAllPossibleMoves(Piece piece, Position curPosition);


    /**
     * Check if the position is within the bounds of the chess board
     *
     * @param row   row value of the given position
     * @param col   column value of the given position
     * @return      true if the row and column both are within the range of chess grid, false otherwise
     */
    public static boolean isInBounds(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE;
    }
}
