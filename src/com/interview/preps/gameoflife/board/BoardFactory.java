package com.interview.preps.gameoflife.board;

public final class BoardFactory {

    private BoardFactory() {
        // noop.
    }

    public static Board newBoardWithGlider(int boardSideSizeInCells) {
        if (boardSideSizeInCells < 3) {
            throw new IllegalArgumentException("Cannot construct game of life board with glider on board of this size");
        }
        Board board = new Board(boardSideSizeInCells, BoardCellStatus.DEAD);

        int xCenter;
        int yCenter;
        xCenter = yCenter = boardSideSizeInCells / 2;

        board.setCellStatus(xCenter - 1, yCenter - 1, BoardCellStatus.ALIVE);

        board.setCellStatus(xCenter, yCenter - 1, BoardCellStatus.ALIVE);
        board.setCellStatus(xCenter, yCenter + 1, BoardCellStatus.ALIVE);

        board.setCellStatus(xCenter + 1, yCenter, BoardCellStatus.ALIVE);
        board.setCellStatus(xCenter + 1, yCenter - 1, BoardCellStatus.ALIVE);

        return board;
    }

    public static Board defaultGliderBoard() {
        return newBoardWithGlider(25);
    }
}
