package com.game.simplechess.board;

import com.game.simplechess.exception.ChessPieceException;
import com.game.simplechess.model.Piece;
import com.game.simplechess.model.PieceName;
import com.game.simplechess.model.Position;
import com.game.simplechess.model.pieces.Pawn;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Getter
@Setter
@Component
public class ChessBoard {

    private Position position;
    private Piece[][] board;
    private GridLabelHelper gridLabelHelper;

    public ChessBoard(GridLabelHelper gridLabelHelper) {
        this.board = new Piece[8][8];
        this.gridLabelHelper = gridLabelHelper;
    }

    /**
     * Sets current position for a given piece on the board
     *
     * @param strPosition   current (row,column) position of the piece in string form
     * @param strPiece      type of chess piece in string form
     */
    public void setPiecePositionOnBoard(String strPosition, String strPiece) {
        Position position = gridLabelHelper.getGridPosition(strPosition);
        Piece piece = getPiece(strPiece);
        board[position.getRow()][position.getColumn()] = piece;
        piece.setPosition(new Position(position.getRow(), position.getColumn()));
    }

    public String[] getAllPossibleMoves(String strPosition, String strPiece) {
        Position position = gridLabelHelper.getGridPosition(strPosition);
        Piece piece = getPiece(strPiece);
        Position[] possibleMoves = piece.getAllPossibleMoves(piece, position);
        return Arrays.stream(possibleMoves).map(p -> gridLabelHelper.getChessNotation(p)).toList().toArray(new String[0]);
    }

    private Piece getPiece(String strPiece) {
        PieceName pieceName = PieceName.fromString(strPiece);
        assert pieceName != null;
        return switch (pieceName) {
            case PAWN -> new Pawn(position);
            case KING, QUEEN -> throw new ChessPieceException(pieceName + " will be added soon");
        };
    }

}
