package com.interview.preps.gameoflife.board;

import java.util.Arrays;

public final class Board {

    private final BoardCellStatus[][] cells;
    private final int boardSideSizeInCells;

    Board(int boardSideSizeInCells, BoardCellStatus defaultStatus) {
        this.cells = new BoardCellStatus[boardSideSizeInCells][boardSideSizeInCells];
        this.boardSideSizeInCells = boardSideSizeInCells;

        if (defaultStatus != null) {
            for (BoardCellStatus[] column : this.cells) {
                Arrays.fill(column, BoardCellStatus.DEAD);
            }
        }
    }

    Board(int boardSideSizeInCells) {
        this(boardSideSizeInCells, null);
    }

    public void setCellStatus(int x, int y, BoardCellStatus status) {
        this.cells[x][y] = status;
    }

    public BoardCellStatus getCellStatus(int x, int y) {
        int size = this.getBoardSideSizeInCells();
        boolean xCoordIsValid = x >= 0 && x < size;
        boolean yCoordIsValid = y >= 0 && y < size;
        if (xCoordIsValid && yCoordIsValid) {
            return this.cells[x][y];
        }
        return null;
    }

    public int getBoardSideSizeInCells() {
        return boardSideSizeInCells;
    }

    public static Board newBoardOfSameSize(Board board) {
        return new Board(board.boardSideSizeInCells);
    }
}
