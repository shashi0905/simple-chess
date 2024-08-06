# simple-chess
A Simple Chess Game in Java - The application simulates the movement of different types of chess pieces on an empty chess board.
Currently, it only supports three types of chess pieces - Pawn, King and Queen. 
But it can be extended to support more types of pieces in the future.

Chessboard: The chessboard is an 8 x 8 grid with 64 cells in it. With 8 rows (1, 2, 3.... 8) and 8 columns (A, B, C.... H),
each cell can be uniquely identified with its cell number. This has been illustrated below:

A8 B8 C8 D8 E8 F8 G8 H8
A7 B7 C7 D7 E7 F7 G7 H7
A6 B6 C6 D6 E6 F6 G6 H6
A5 B5 C5 D5 E5 F5 G5 H5
A4 B4 C4 D4 E4 F4 G4 H4
A3 B3 C3 D3 E3 F3 G3 H3
A2 B2 C2 D2 E2 F2 G2 H2
A1 B1 C1 D1 E1 F1 G1 H1

Movement of the Chess Pieces -
1. Pawn - It can only move 1 step at a time, in the vertical forward direction.
2. King - It can only move 1 step at a time, in all 8 directions (vertical, horizontal and diagonal)
3. Queen - It can move across the board in all 8 directions.

Inputs and Outputs to the application:
● Input - The input string to the application will be the Type of chess piece, and it’s position (cell number) on the
chessboard. E.g. Pawn, G1
● Output - The output is a string of all possible cells in which the chess piece can move from its current position. 
For the above input, the output would be G2.

Setup and Running The Application -

Pre-requisites:
1. Java 17 or above
2. Maven

Build the application using maven -
mvn clean install, or
mvn clean install -DskipTests=true  (if you want to skip the unit tests execution)

Run the application using below command -
mvn spring-boot:run

Assumptions -
1. The application only simulates the movement of certain types of chess pieces on a 2D Chess Grid
2. This is not a complete chess game, but builds the foundation for a chess game configuration. 
3. While finding all the possible moves, it assumes that all cells are empty, and not occupied by any other piece.
4. The notation followed for the position is Position(row, column) where row -> y and column -> x coordinate.
5. For the outside world, application follows the standard notation of A1, B1... H8 