package com.game.simplechess;

import com.game.simplechess.board.ChessBoard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SimpleChessApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleChessApplication.class);

    @Autowired
    private ChessBoard chessBoard;

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(SimpleChessApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        LOG.info("WELCOME TO THE SIMPLE CHESS APPLICATION");
        Scanner sc = new Scanner(System.in);

        while(true) {
            LOG.info("Please Enter the Piece Type (e.g., Pawn, King, or Queen)...");
            String pieceType = sc.nextLine();
            LOG.info("Please Enter the Position (e.g., A1, B4, H8 etc.)...");
            String position = sc.nextLine().toUpperCase();


            chessBoard.setPiecePositionOnBoard(position, pieceType);
            LOG.info("Following are the list of possible moves - ");
            List<String> allPossibleMoves = chessBoard.getAllPossibleMoves(position, pieceType);
            if (!allPossibleMoves.isEmpty())
                LOG.info(String.join(", ", allPossibleMoves));
            else
                LOG.info("No Possible Moves from the given position.");

            LOG.info("Do you wish to continue (Y/N) ?");
            String resume = sc.nextLine();
            if(!resume.equalsIgnoreCase("Yes") && !resume.equalsIgnoreCase("Y")) {
                sc.close();
                break;
            }
        }
    }

}
