package com.game.simplechess.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
    public Piece(Position position){
        this.position = position;
    }

    public abstract Position[] getAllPossibleMoves(Piece piece, Position curPosition);
}
