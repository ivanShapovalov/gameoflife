package com.interview.preps.gameoflife.output;

import com.interview.preps.gameoflife.board.Board;

public interface StatePrinter<T> {
    T print(Board board);
}
