package com.interview.preps.gameoflife;

import com.interview.preps.gameoflife.board.Board;

public final class GameOfLife {

    private final BoardTransformer boardTransformer;
    private Board currentBoard;

    public GameOfLife(BoardTransformer boardTransformer, Board currentBoard) {
        this.boardTransformer = boardTransformer;
        this.currentBoard = currentBoard;
    }

    public void nextStep() {
        this.currentBoard = this.boardTransformer.nextStep(this.currentBoard);
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }
}
