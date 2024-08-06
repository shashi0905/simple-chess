package com.game.simplechess.model;

import lombok.Getter;

@Getter
public enum PieceName {
    PAWN("Pawn"),
    KING("King"),
    QUEEN("Queen");

    private final String name;

    PieceName(String pieceName) {
        this.name = pieceName;
    }

    public static PieceName fromString(String text) {
        for (PieceName b : PieceName.values()) {
            if (b.name.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
