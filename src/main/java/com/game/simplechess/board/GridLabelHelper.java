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

    public String getChessNotation(Position pos) {
        return String.valueOf(columnLabels[pos.getColumn()]) + (pos.getRow() + 1);
    }

    public Position getGridPosition(String pos) {
        return new Position(Integer.parseInt(pos.substring(1)) - 1, columnMap.get(pos.charAt(0)));
    }
}
