package com.game.simplechess.board;

import com.game.simplechess.exception.ChessPieceException;
import com.game.simplechess.model.Piece;
import com.game.simplechess.model.PieceName;
import com.game.simplechess.model.Position;
import com.game.simplechess.model.pieces.King;
import com.game.simplechess.model.pieces.Pawn;
import com.game.simplechess.model.pieces.Queen;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.game.simplechess.board.ChessBoardConstants.BOARD_SIZE;

@Getter
@Setter
@Component
public class ChessBoard {

    private Position position;
    private Piece[][] board;
    private GridLabelHelper gridLabelHelper;

    public ChessBoard(GridLabelHelper gridLabelHelper) {
        this.board = new Piece[BOARD_SIZE][BOARD_SIZE];
        this.gridLabelHelper = gridLabelHelper;
    }

    /**
     * Sets current position for a given piece on the board
     *
     * @param strPosition current (row,column) position of the piece in string form
     * @param strPiece    type of chess piece in string form
     */
    public void setPiecePositionOnBoard(String strPosition, String strPiece) {
        Position targetPosition = gridLabelHelper.getGridPosition(strPosition);
        Piece piece = getPiece(strPiece);
        board[targetPosition.getRow()][targetPosition.getColumn()] = piece;
        piece.setPosition(new Position(targetPosition.getRow(), targetPosition.getColumn()));
    }

    public List<String> getAllPossibleMoves(String strPosition, String strPiece) {
        Position curposition = gridLabelHelper.getGridPosition(strPosition);
        Piece piece = getPiece(strPiece);
        List<Position> possibleMoves = piece.getAllPossibleMoves(piece, curposition);
        return possibleMoves.stream().map(p -> gridLabelHelper.getChessNotation(p)).toList();
    }

    public Piece getPieceOnBoardPosition(Position position) {
        return this.board[position.getRow()][position.getColumn()];
    }

    private Piece getPiece(String strPiece) {
        PieceName pieceName = PieceName.fromString(strPiece);
        if (pieceName != null) {
            return switch (pieceName) {
                case PAWN -> new Pawn(position);
                case KING -> new King(position);
                case QUEEN -> new Queen(position);
            };
        } else throw new ChessPieceException("Missing Chess Piece Name");
    }
}
