package com.interview.preps.gameoflife;

import com.interview.preps.gameoflife.board.Board;
import com.interview.preps.gameoflife.board.BoardCellStatus;

import java.util.concurrent.atomic.AtomicInteger;

public class BoardTransformer {
    public Board nextStep(Board previousStepBoard) {
        Board nextStepBoard = Board.newBoardOfSameSize(previousStepBoard);

        for (int x = 0; x < nextStepBoard.getBoardSideSizeInCells(); x++) {
            for (int y = 0; y < nextStepBoard.getBoardSideSizeInCells(); y++) {
                int aliveNeighbours = countAliveNeighbours(previousStepBoard, x, y);
                BoardCellStatus previousCellStatus = previousStepBoard.getCellStatus(x, y);
                BoardCellStatus nextStepCellStatus = getNextStepCellStatus(previousCellStatus, aliveNeighbours);
                nextStepBoard.setCellStatus(x, y, nextStepCellStatus);
            }
        }

        return nextStepBoard;
    }
    private BoardCellStatus getNextStepCellStatus(BoardCellStatus previousStatus, int aliveNeighbours) {
        BoardCellStatus nextStatus = previousStatus;

        if (previousStatus == BoardCellStatus.ALIVE) {
            if (aliveNeighbours < 2) {
                nextStatus = BoardCellStatus.DEAD;
            } else if (aliveNeighbours > 3) {
                nextStatus = BoardCellStatus.DEAD;
            }
        } else if (previousStatus == BoardCellStatus.DEAD) {
            if (aliveNeighbours == 3) {
                nextStatus = BoardCellStatus.ALIVE;
            }
        }

        return nextStatus;
    }

    private int countAliveNeighbours(Board board, int x, int y) {
        AtomicInteger aliveNeighbours = new AtomicInteger(0);

        incrementIfAlive(board, x - 1, y - 1, aliveNeighbours);
        incrementIfAlive(board, x - 1, y, aliveNeighbours);
        incrementIfAlive(board, x - 1, y + 1, aliveNeighbours);

        incrementIfAlive(board, x, y + 1, aliveNeighbours);
        incrementIfAlive(board, x, y - 1, aliveNeighbours);

        incrementIfAlive(board, x + 1, y - 1, aliveNeighbours);
        incrementIfAlive(board, x + 1, y, aliveNeighbours);
        incrementIfAlive(board, x + 1, y + 1, aliveNeighbours);

        return aliveNeighbours.get();
    }

    private void incrementIfAlive(Board board, int x, int y, AtomicInteger accumulator) {
        BoardCellStatus cellStatus = board.getCellStatus(x, y);
        if (cellStatus == BoardCellStatus.ALIVE) {
            accumulator.incrementAndGet();
        }
    }
}
