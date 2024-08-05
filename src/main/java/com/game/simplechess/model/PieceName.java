package com.game.simplechess.model;

import lombok.Getter;

@Getter
public enum PieceName {
    PAWN("Pawn"),
    KING("King"),
    QUEEN("Queen");

    private final String pieceName;

    PieceName(String pieceName) {
        this.pieceName = pieceName;
    }

    public static PieceName fromString(String text) {
        for (PieceName b : PieceName.values()) {
            if (b.pieceName.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
