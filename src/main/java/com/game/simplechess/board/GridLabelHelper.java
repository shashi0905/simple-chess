package com.game.simplechess.board;

import com.game.simplechess.model.Position;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GridLabelHelper {

    private static final Character[] columnLabels = new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    private static final Map<Character, Integer> columnMap = new HashMap<>();

    static {
        // Initialize the column map
        for (int i = 0; i < columnLabels.length; i++) {
            columnMap.put(columnLabels[i], i);
        }
    }

    /**
     * Converts the given grid position to the standard chess notation.
     * For Example, (0,0) translates to A1; (7,7) translates to H8
     *
     * @param pos   Given Position(row, col) Instance.
     * @return      String representation of Standard Chess Notation e.g, A1, B4, H6 etc.
     */
    public String getChessNotation(Position pos) {
        return String.valueOf(columnLabels[pos.getColumn()]) + (pos.getRow() + 1);
    }

    /**
     * Converts the given String notation to Chess Grid Position(row, col)
     * @param pos   String value of standard notation like A1, B7 etc.
     * @return      Position mapping for the given string notation.
     */
    public Position getGridPosition(String pos) {
        return new Position(Integer.parseInt(pos.substring(1)) - 1, columnMap.get(pos.charAt(0)));
    }
}
