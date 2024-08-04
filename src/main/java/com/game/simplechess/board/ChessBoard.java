package com.game.simplechess.board;

import com.game.simplechess.model.Piece;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChessBoard {

    private int rows;
    private int cols;
    private Piece[][] board;

    public ChessBoard(int rows, int cols) {
        this.board = new Piece[8][8];
    }

    /**
     * Sets current position for a given piece on the board
     *
     * @param row   current row position of the piece - y coordinate
     * @param col   current column position of the piece - x coordinate
     * @param piece type of chess piece
     */
    public void setPiecePositionOnBoard(int row, int col, Piece piece) {
        board[row][col] = piece;
        if(piece != null){
            piece.setX(col);
            piece.setY(row);
        }
    }

}
