package tictactoe.logic;

import tictactoe.model.Board;

public interface GameEvaluator {
    boolean evaluate(Board board);
}
