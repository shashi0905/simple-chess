package com.game.simplechess.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Class to represent the chess board positions.
 * row -> y coordinate (vertical direction/movements)
 * col -> x cooridnate (horizontal movement across grid)
 */
@Getter
@Setter
@AllArgsConstructor
public class Position {
    private int row;
    private int column;
}