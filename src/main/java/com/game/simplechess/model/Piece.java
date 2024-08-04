package com.game.simplechess.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public abstract class Piece {
    private PieceColor pieceColor;
    private int x;
    private int y;

    public abstract Boolean getAllPossibleMoves(Piece piece, int x, int y);
}
