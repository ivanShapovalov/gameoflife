package com.interview.preps.gameoflife;

import com.interview.preps.gameoflife.board.Board;
import com.interview.preps.gameoflife.board.BoardFactory;
import com.interview.preps.gameoflife.output.console.ConsoleStatePrinter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Board board = BoardFactory.defaultGliderBoard();
        BoardTransformer boardTransformer = new BoardTransformer();

        GameOfLife gameOfLife = new GameOfLife(boardTransformer, board);
        ConsoleStatePrinter consoleStatePrinter = new ConsoleStatePrinter();

        // Introducing some kind of game runner which will hold delay, threads
        // and stuff like that may be a good idea.
        while (true) {
            consoleStatePrinter.print(gameOfLife.getCurrentBoard());
            Thread.sleep(1000);
            gameOfLife.nextStep();
        }
    }
}
