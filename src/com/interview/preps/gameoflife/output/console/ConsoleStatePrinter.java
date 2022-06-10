package com.interview.preps.gameoflife.output.console;

import com.interview.preps.gameoflife.board.Board;
import com.interview.preps.gameoflife.board.BoardCellStatus;
import com.interview.preps.gameoflife.output.StatePrinter;

import static java.lang.System.out;

public class ConsoleStatePrinter implements StatePrinter<Void> {
    @Override
    public Void print(Board board) {
        int boardSideSizeInCells = board.getBoardSideSizeInCells();

        for (int y = boardSideSizeInCells - 1; y >= 0; y--) {
            StringBuilder rowStringBuilder = new StringBuilder();
            for (int x = 0; x < boardSideSizeInCells; x++) {
                BoardCellStatus cellStatus = board.getCellStatus(x, y);
                if (cellStatus == BoardCellStatus.ALIVE) {
                    rowStringBuilder.append(" O ");
                } else {
                    rowStringBuilder.append("   ");
                }
            }
            out.println(rowStringBuilder);
        }

        return null;
    }
}
